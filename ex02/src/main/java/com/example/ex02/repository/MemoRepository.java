package com.example.ex02.repository;

import com.example.ex02.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> { //<엔티티클래스, 키값의 타입>
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to); //쿼리메소드 (메소드 명을 쿼리처럼)

    @Query(value = "select * from memo where mno >= 10 and mno <= 20 order by mno desc", nativeQuery = true)
    List<Memo> getListDesc();

    //JPQL(DB독립적으로 사용하기 위해 - 객체지향 쿼리: 테이블 대신 엔티티클래스이름, 테이블의 컬럼대신 클래스에 선언된 필드
    //SQL과 유사하지만 다름
    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getListDescJPQL();

    @Query("select m.memoText from Memo m order by m.mno desc")
    List<String> getListDescJPQL2();

    //JPQL 파라미터 바인딩
    @Query("select m from Memo m where m.mno between :num1 and :num2 order by m.mno desc")
    List<Memo> getListDescJPQLbyParamBinding(@Param("num1") long num1, @Param("num2") long num2);

    //JPQL 객체바인딩 #
    @Modifying  //update 또는 delete 쿼리는 어노테이션 두개 필요 (Transactional 어노테이션은 테스트코드(실행될 코드?)에 붙여도 됨
    @Transactional  //테스트코드에만 사용시 테스트만하고 롤백됨
    @Query("update Memo m set m.memoText = :#{#memo.memoText} where m.mno = :#{#memo.mno}") //게터가 있어야됨
    int updateMemoText(@Param("memo") Memo memo);

    @Query(value = "select m from Memo m where m.mno > :mno", countQuery = "select count(m) from Memo m where m.mno > :mno")
    Page<Memo> getListWithQuery(@Param("mno") Long mno, Pageable pageable);
    //countQuery - Page타입 객체가 처리결과의 수도 포함하는데 그것을 넣어주기 위함임

    @Query("select m.mno, m.memoText, CURRENT_DATE from Memo m order by m.mno") //Object 배열로 받을 수 있음
    List<Object[]> testGetObj();

    @Query("select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno = :mno") //Object 배열로 받을 수 있음
    List<Object[]> getListWithQueryObject(Long mno);  //이름이 같으면 @Param 생략 가능

    @Query("select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno < :mno") //Object 배열로 받을 수 있음
    Object[] getListWithQueryObject2(Long mno);  //이름이 같으면 @Param 생략 가능

}
