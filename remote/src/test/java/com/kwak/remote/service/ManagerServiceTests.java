package com.kwak.remote.service;

import com.kwak.remote.dto.ManagerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManagerServiceTests {
    @Autowired
    private ManagerService service;

    @Test
    public void testInsert(){
        service.insert(ManagerDTO.builder()
                .pno(131L)
                .part("입국거부")
                .name("안가요")
                .tel("010-9191-9123")
                .build());
    }

    @Test
    public void testGetData(){
        service.getData().forEach(System.out::println);
    }
}
