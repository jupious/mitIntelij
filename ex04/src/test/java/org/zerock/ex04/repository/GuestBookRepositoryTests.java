package org.zerock.ex04.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Visitor;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.ex04.entity.GuestBook;
import org.zerock.ex04.entity.QGuestBook;

import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootTest
@Log4j2
public class GuestBookRepositoryTests {
    @Autowired
    private GuestBookRepository guestBookRepository;

    /*@Test
    public void testInsert(){
        GuestBook guestBook = GuestBook.builder()
                .title("테스트제목")
                .content("테스트 내용")
                .writer("테스트 작성자")
                .build();
        guestBookRepository.save(guestBook);
    }

    @Test
    public void testInsertDummy(){
        LongStream.rangeClosed(1,100).forEach(i ->{
            GuestBook guestBook = GuestBook.builder()
                    .title("테스트제목"+i)
                    .content("테스트 내용"+i)
                    .writer("테스트 작성자"+i)
                    .build();
            guestBookRepository.save((guestBook));
        });
    }

    @Test
    public void testRead(){
        guestBookRepository.findById(1L).ifPresent(System.out::println);
    }

    @Test
    public void testUpdate(){
        GuestBook guestBook = GuestBook.builder()
                .gno(2L)
                .title("하바 바꿔버림")
                .content("업데이트~")
                .writer("누구게")
                .build();
        guestBookRepository.save(guestBook);
    }

    @Test
    public void testDelete(){
        guestBookRepository.deleteById(3L);
    }

    @Test
    public void testPaging(){
        Pageable pageable = PageRequest.of(0,10);
        Page<GuestBook> res = guestBookRepository.findAll(pageable);
        log.info("결과");
        res.getContent().forEach(x ->{
            log.info(x);
        });

    }*/
    //QueryDsl 사용테스트

//    @Test
//    public void testInsertDummy(){
//        LongStream.rangeClosed(1,10).forEach(i ->{
//            GuestBook guestBook = GuestBook.builder()
//                    .title("테스트제목"+i)
//                    .content("테스트 내용"+i)
//                    .writer("테스트 작성자"+i)
//                    .build();
//            guestBookRepository.save((guestBook));
//        });
//    }

    @Test
    public void testQuerydsl1(){
        //1.Q도메인 객체 생성
        QGuestBook qGuestBook = QGuestBook.guestBook;
        //2.조건을 세팅하기위한 객체 생성
        BooleanBuilder builder = new BooleanBuilder();
        //3.조건 생성
        BooleanExpression expression1 = qGuestBook.title.contains("1");
        BooleanExpression expression2 = qGuestBook.writer.contains("1");
        BooleanExpression expression3 = qGuestBook.content.contains("1");
        //ex1 and (ex2 or ex3)
        BooleanExpression expression4 = expression2.or(expression3).and(expression1);
        //4.조건 합치기(처음조건은 항상 and)
        builder.and(expression4);
        //5.결과요청
        Page<GuestBook> res = guestBookRepository.findAll(builder, PageRequest.of(
                                                        0,10, Sort.by("gno").descending()));
        res.forEach(System.out::println);
    }
}
