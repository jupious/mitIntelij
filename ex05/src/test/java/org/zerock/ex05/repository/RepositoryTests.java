package org.zerock.ex05.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex05.entity.Board;
import org.zerock.ex05.entity.Member;
import org.zerock.ex05.entity.Reply;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testInsert(){
        for(int i = 0; i<100;i++){
            memberRepository.save(Member.builder()
                    .email("tester"+i+"@abc.com")
                    .name("name1"+i)
                    .password("pw"+i).build());
        }
    }

    @Test
    public void testBoardInsert(){
        Board board = Board.builder()
                .title("테스트제목2")
                .content("테스트내용2")
                .member(Member.builder().email("tester0@abc.com").build())
                .build();
        boardRepository.save(board);
    }

    @Test
    public void testBoardInsert2(){
        Board board = Board.builder()
                .title("테스트제목")
                .content("테스트내용")
                .build();
        boardRepository.save(board);
    }

    @Test
    public void testFindBoard1(){
        boardRepository.findById(1L).ifPresent(System.out::println);
    }

    @Test
    public void testReplyInsert(){
        replyRepository.save(Reply.builder()
                .text("2댓글이다")
                .replyer("2댓글작성자다")
                .board(Board.builder().gno(1L).build())
                .build());
    }
    @Test
    @Transactional
    public void testSFindReply1(){
        //불필요한 조인으로 성능저하 -> 필요한 모든것을 로드하는걸 Eager loding이라고함(즉시로딩, 반대말은 lazy loding)
        replyRepository.findById(1L).ifPresent(x-> System.out.println(x.getBoard()));

    }

    @Test
    public void testSFindReply2(){
        replyRepository.findById(1L).ifPresent(System.out::println);

    }

    @Test
    public void testGetMemberInBoard(){
        Object obj = boardRepository.getBoardWithMember(1L);


    }

    @Test
    public void testGetReplyInBoard(){
        List<Object[]> res = boardRepository.getBoardWithReply(1L);
        res.forEach(x->{
            for(Object o : x){
                System.out.println(o);
            }
            System.out.println("===================");
        });

    }
    //JPQL에서 수정,삭제시에는 Modifying, transactional 어노테이션 필요!

    //ManyToOne 정리
    /*
    1. DB의 1:n 관계를 표현하기위해서 n쪽 엔티티에서 @ManytoOne 어노테이션을 붙여서 구성한다(단방향 참조)
    2. 엔티티 접근시 무조건 참조되는 데이터를 가져오기 위해 불필요한 join을 사용하기 때문에 성능 향상을 위해
        Lazy loding옵션을 추가해서 필요할때만 사용되도록 바꾼다(단, 참조중인 객체를 가져오려면 트랜잭션처리를
        위해 어노테이션 필요
    3. Lazy loding 옵션을 주더라도 ToString 어노테이션이 추가되어있다면 참조되는 객체는 exclude 옵션으로
        제외시켜주어야 toString 호출시 성능저하를 방지 할 수 있다.
    4. 그럼에도 불필요한 트랜잭션처리 보다 한번의 최적쿼리 시행을 위해 JPQL을 사용 할 수 있다.
        또한 연관관계가 없는 join이나 단방향 참조임으로 역방향 참조를 위해 JPQL이 사용된다.
        (양방향 참조를 통해 JPQL없이 사용이 가능하나, 제대로 모르고 쓰면 여러 문제가 발생함으로 단방향 참조 권장)
    5. JPQL사용시 참조관계가 있는 엔티티는 (ex- a가 b를 참조) a join a.b 형태로 사용 가능하고
        참조 관계가 없는 경우 a join b on a.no = b.no 형태로 사용할 수 있다.
    6. JPQL 사용시 수정과 삽입시에는 @Modifying 어노테이션이 꼭 필요하다.
    */


}
