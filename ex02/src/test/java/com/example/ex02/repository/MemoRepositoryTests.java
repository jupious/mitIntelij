package com.example.ex02.repository;

import com.example.ex02.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository mr;

    @Test
    public void testClass(){
        System.out.println("테스트==========================================================="+mr.getClass().getName());
    }

    @Test   //데이터 삽입(create)
    public void testInsertDummy(){
//        for(long i = 1; i <= 100; i++){
//            Memo m = new Memo("테스트 내용이지롱"+i);
//            mr.save(m);
//        }
        LongStream.rangeClosed(1,100).forEach(i -> {
            Memo m = Memo.builder().memoText("LongStream과 빌더패턴이용"+i)
                                   .build();
            mr.save(m);
        });
    }

    @Test //데이터 조회(read)
    public void testSelect(){
        Optional<Memo> result = mr.findById(99L);
        System.out.println("========================================");
        //result.ifPresent(System.out::println); //이런것도 가능하네
        if(result.isPresent())
            System.out.println(result.get());
        else
            System.out.println("값이 없음");

    }
    
    @Transactional //getOne을 쓰려면 필요함
    @Test //데이터 조회2(비추되는듯?) getOne은 객체가 필요하기 전까지 쿼리를 실행하지 않음 -> 트랜잭션필요 이유
    public  void testSelect2(){
        Memo memo = mr.getReferenceById(99L);   //getOne과 똑같이 동작
        System.out.println("========================================");
        System.out.println(memo);
    }

    @Test //데이터 갱신(update)
    public void testUpdate(){
        Memo memo = Memo.builder().mno(1L).memoText("하하 넌 바꾼 값이다").build();
        //이미 존재하는 내용이라면(키값이 같다면) 자동으로 수정됨 - 값을 먼저 조회 후 결정해서 실행됨
        mr.save(memo);
    }

    @Test //데이터 삭제(Delete)
    public void testDelete(){
        mr.deleteById(3L);
        //삭제할 값이 존재하는지 조회 후 삭제 - 없다면 예외발생
        //DB에서 삭제시 없는 값이라도 오류가 발생하지 않기때문
    }

    @Test //데이터 삭제2
    public void testDelete2(){
        Memo memo = Memo.builder().mno(33L).memoText("LongStream과 빌더패턴이용33").build(); //없어도 예외X
        mr.delete(memo);
    }

    @Test //페이지 처리
    public void testPageDefault(){
        //1페이지에 10개를 보고싶을때  (10개씩 페이지를 처리해서 첫번째 페이지)
        Pageable pagable = PageRequest.of(0,10);

        Page<Memo> res = mr.findAll(pagable);
        System.out.println("페이징 처리결과"+ res);
        res.getContent().forEach(x -> {
            System.out.println("글번호 ="+x.getMno() + " 글 내용"+x.getMemoText());
        });
    }

    @Test //정렬하기
    public void testSort(){
        Sort sort = Sort.by("mno").descending();
        Page<Memo> res = mr.findAll(PageRequest.of(0,10,sort));
        res.getContent().forEach(System.out::println);
    }

    @Test //다중 조건 정렬
    public void testMultiSort(){
        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").descending();
        Sort sort3 = sort1.and(sort2);
        //order by mno desc, memoText desc;
    }

    @Test //쿼리 직접지원 - 쿼리메소드
    public void testQueryMethod(){
        mr.findByMnoBetweenOrderByMnoDesc(12L,23L).forEach(System.out::println);
    }

    @Test //쿼리 직접사용
    public void testNativeQuery(){
        mr.getListDesc().forEach(System.out::println);
    }

    @Test //JPQL사용
    public void testJPQL(){
        mr.getListDescJPQL().forEach(System.out::println);
    }

    @Test //JPQL사용
    public void testJPQL2(){
        mr.getListDescJPQL2().forEach(System.out::println);
    }

    @Test //JPQL파라미터 바인딩
    public void testJPQLBinding(){
        mr.getListDescJPQLbyParamBinding(10L,15L).forEach(System.out::println);
    }
    @Test
    public void testUpdateJPQL(){
        System.out.println(mr.updateMemoText(new Memo(10L,"JPQL테스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")));
    }

    @Test
    public void testGetObject(){
        mr.testGetObj().forEach(x ->{
            System.out.println(x[0]+"==========="+x[1]+"================"+x[2]);
        });
    }

    @Test
    public void testGetListWithQuery(){
        mr.getListWithQuery(10L, PageRequest.of(0,10)).forEach(System.out::println);
    }

    @Test
    public void testGetListWithQueryObject(){
       mr.getListWithQueryObject(90L).forEach(x -> System.out.println(x[0]+"  "+x[1]+" "+x[2]));


    }

    @Test
    public void testGetListWithQueryObject2(){
        Object[] obj = mr.getListWithQueryObject2(10L);
        for(Object o : obj){
            Object[] test = (Object[]) o;
            System.out.println(Arrays.toString(test));
        }
    }

    @Test
    public void arraysPrint(){
        int[] arr= {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
    }
}
