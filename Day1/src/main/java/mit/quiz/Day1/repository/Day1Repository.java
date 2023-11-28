package mit.quiz.Day1.repository;

import jakarta.transaction.Transactional;
import mit.quiz.Day1.entity.Day1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface Day1Repository extends JpaRepository<Day1,String>, QuerydslPredicateExecutor<Day1> {

    @Modifying
    @Transactional
    @Query(value = "delete from day1",nativeQuery = true)
    int deleteAllDatas();
}
