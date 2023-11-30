package org.zerock.ex04.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {
    @Builder.Default    //빌더 사용 시에도 초기값 세팅을 위해
    private int page = 1;
    @Builder.Default
    private int size = 10;


    public Pageable getPageable(Sort sort){
        return PageRequest.of(page-1,size,sort);
    }
}
