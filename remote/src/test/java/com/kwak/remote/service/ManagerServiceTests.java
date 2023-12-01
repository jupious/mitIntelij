package com.kwak.remote.service;

import com.kwak.remote.dto.ManagerDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ManagerServiceTests {
    @Autowired
    private ManagerService service;

    @Test
    public void testInsert(){
        
        if(service.insert(ManagerDTO.builder()
                .pno(131L)
                .part("입국거부")
                .name("안가요")
                .tel("010-9191-9123")
                .build())){
            log.info("성공");
        }else{
            log.info("실패");
        }
        

    }

    @Test
    public void testGetData(){
        service.getDataList().forEach(System.out::println);
    }

    @Test
    public void testDupCheck(){
       log.info(service.dupCheck(131L));
    }
}
