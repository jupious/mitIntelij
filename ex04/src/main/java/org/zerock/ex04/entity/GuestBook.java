package org.zerock.ex04.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestBook extends BasicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성값(정책=자동 생성(숫자1씩 올라가는거))
    private Long gno;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)
    private String content;
    @Column(length = 100, nullable = false)
    private String writer;

}
