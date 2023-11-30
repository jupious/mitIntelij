package com.kwak.remote.repository;

import com.kwak.remote.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManagerRepositoryTests {
    @Autowired
    ManagerRepository managerRepository;

    @Test
    public void testInsert(){
        Manager m = Manager.builder()
                .pno(1123L)
                .part("선체설계")
                .name("배홍동")
                .tel("010-1234-5678")
                .build();
        managerRepository.save(m);
    }
}
