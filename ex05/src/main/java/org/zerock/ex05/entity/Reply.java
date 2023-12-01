package org.zerock.ex05.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString(exclude = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BasicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성값(정책=자동 생성(숫자1씩 올라가는거))
    private Long rno;
    @Column(length = 100, nullable = false)
    private String text;

    private String replyer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;


}
