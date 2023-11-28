package com.example.ex02.entity;

import lombok.*;

import javax.persistence.*;

@Entity //엔티티 클래스
//@Table(name = "tbl_memo")   //테이블 이름 생략시 클래스명으로 만듦
@ToString
@AllArgsConstructor
@NoArgsConstructor  //기본생성자 필수
@Getter
@Builder //빌더패턴 으로 객체를 생성할 수 있게함
public class Memo {
    @Id //pk 지정(엔티티 클래스에서 필수)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성값(정책=자동 생성(숫자1씩 올라가는거))
    private Long mno;   //글번호

    //@Column(length = 200, nullable = false) //길이는 200자 널 허용 안함
    private String memoText;    //낙타표기법은 뱀 표기법으로 바꿔서 만듦

}


