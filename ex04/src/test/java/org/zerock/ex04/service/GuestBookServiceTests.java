package org.zerock.ex04.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex04.dto.GuestBookDTO;
import org.zerock.ex04.dto.PageRequestDTO;
import org.zerock.ex04.dto.PageResultDTO;
import org.zerock.ex04.entity.GuestBook;

@SpringBootTest
@Log4j2
public class GuestBookServiceTests {
    @Autowired
    private GuestBookService guestBookService;

    @Test
    public void testRegister(){


        for(int i = 0; i < 200; i++){
            guestBookService.register(GuestBookDTO.builder()
                    .title("서비스테스트입니다"+i)
                    .content("테스트내용입니다"+i)
                    .writer("서비스작성자"+i).build());
        }
    }

    @Test
    public void testGetList(){

        PageResultDTO<GuestBookDTO, GuestBook> result = guestBookService.getList(new PageRequestDTO());
        result.getDtoList().forEach(System.out::println);
        System.out.println(result);
    }

    @Test
    public void testSearch(){
         PageResultDTO<GuestBookDTO,GuestBook> result = guestBookService.search(new PageRequestDTO(),"TW","내용");
         result.getDtoList().forEach(System.out::println);
    }

    @Test
    public void testRead(){
       log.info(guestBookService.read(234L));
    }
}
