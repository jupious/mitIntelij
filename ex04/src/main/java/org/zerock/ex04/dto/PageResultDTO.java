package org.zerock.ex04.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO,Entity> {
    //Page<Entity> -> List<DTO>
    private List<DTO> dtoList;

    //총페이지 수
    private int totalPage;
    //현재 페이지번호
    private int page;
    //목록 사이즈
    private int size;
    //시작 페이지번호
    private int start;
    //끝 페이지번호
    private int end;
    //이전, 다음표시여부

    private boolean prev,next;
    //화면에 표시할 페이지번호 목록
    private List<Integer> pageList;

    public PageResultDTO(Page<Entity> result, Function<Entity, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages(); //전체 페이지 수
        makePageList(result.getPageable());


    }

    private void makePageList(Pageable pageable){
        page = pageable.getPageNumber()+1;
        size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0))*10;
        start = tempEnd - 9;
        end = totalPage < tempEnd ? totalPage : tempEnd;
        prev = start != 1;
        next = totalPage != end;


        pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }
}
