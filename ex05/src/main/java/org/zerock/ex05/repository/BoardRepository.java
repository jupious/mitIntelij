package org.zerock.ex05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.ex05.entity.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    //게시글과 작성자 가져오기
    @Query("select b, m from Board b left join b.member m where b.gno = :gno")
    Object getBoardWithMember(Long gno);

    @Query("select b,r from Board b left join Reply r on b.gno=:gno ")
    List<Object[]> getBoardWithReply(@Param("gno") Long gno);
}
