package com.kwak.remote.repository;

import com.kwak.remote.dto.ManagerDTO;
import com.kwak.remote.entity.Manager;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
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

    @Test
    public void why(){
        ManagerDTO managerDTO = ManagerDTO.builder()
                .pno(131L)
                .part("입국거부")
                .name("안가요")
                .tel("010-9191-9123")
                .build();
       log.info(managerRepository.findById(managerDTO.getPno()).isEmpty());
    }
}
