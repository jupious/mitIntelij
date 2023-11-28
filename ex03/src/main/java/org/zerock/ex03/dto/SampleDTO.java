package org.zerock.ex03.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
//toBuilder는 기존에 구성된 빌더를 기반으로 새로운 객체를 재구성 할수 있도록 도와주는 속성
//빌더로 userDTO만들고 userDTO.toBuilder를 통해서 사용 가능
//생성자가 필요하다면 생성자어노테이션 두개 필요
public class SampleDTO {
    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;
}
