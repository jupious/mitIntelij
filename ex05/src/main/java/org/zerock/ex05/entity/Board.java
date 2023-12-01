package org.zerock.ex05.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString(exclude = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BasicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성값(정책=자동 생성(숫자1씩 올라가는거))
    private Long gno;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)
    private String content;
    //지연로딩(필요할때 호출)으로 변경
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
