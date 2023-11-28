package mit.quiz.Day1.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import mit.quiz.Day1.entity.Day1;
import mit.quiz.Day1.entity.QDay1;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.stream.IntStream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Day1RepositoryTests {
    @Autowired
    private Day1Repository day1Repository;

    @Test
    @Order(1)
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Day1 day1 = Day1.builder()
                    .id(i+"")
                    .pw((101-i)+"")
                    .memo("아아아")
                    .build();
            day1Repository.save(day1);
        });
    }

    @Test
    @Order(2)
    public void testUpdate(){
        Day1 day1 = Day1.builder()
                .id("5")
                .memo("변경합니다")
                .pw("96")
                .build();
        day1Repository.save(day1);
    }

    @Test
    @Order(3)
    public void testRead(){
        day1Repository.findById("4").ifPresent(System.out::println);
    }

    @Test
    @Order(4)
    public void testSearch(){
        QDay1 qDay1 = QDay1.day1;

        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression idCheck = qDay1.id.contains("1");
        BooleanExpression pwCheck = qDay1.pw.contains("1");
        builder.and(idCheck).and(pwCheck);
        Page<Day1> res = day1Repository.findAll(builder,PageRequest.of(1,2));
        res.forEach(System.out::println);
    }

    @Test
    @Order(5)
    public void testDeleteAll(){
        System.out.println("지운 데이터 수: "+day1Repository.deleteAllDatas());
    }

    @Test
    public void ztestReal(){
        day1Repository.deleteAll();
    }
}
