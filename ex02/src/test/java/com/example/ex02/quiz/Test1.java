package com.example.ex02.quiz;

import com.example.ex02.entity.User;
import com.example.ex02.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test1 {
    @Autowired
    UserRepository ur;

    @Test
    @Order(1)
    public void createTblUser(){
        IntStream.rangeClosed(0,99).forEach(x ->{
            User usr = User.builder()
                    .id("user" + (x < 10 ? "0"+ x : x))
                    .pw(x+1+"")
                    .build();
            ur.save(usr);
        });
    }

    @Test
    @Order(2)
    public void deleteUser(){
        ur.deleteById("user50");
    }


    @Test
    @Order(3)
    public void updatePw(){
        ur.save(new User("user01","1234"));
    }

    @Test
    @Order(4)
    public void searchUser(){
        Optional<User> res = ur.findById("user01");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        if(res.isPresent()){
            System.out.println(res.get().getPw());
        }else{
            System.out.println("user01이 존재하지 않습니다.");
        }
    }
}
