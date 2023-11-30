package org.zerock.ex04.service;

import org.zerock.ex04.dto.GuestBookDTO;
import org.zerock.ex04.dto.PageRequestDTO;
import org.zerock.ex04.dto.PageResultDTO;
import org.zerock.ex04.entity.GuestBook;

public interface GuestBookService {
    //등록
    Long register(GuestBookDTO dto); //몇번 게시글이 등록됐는지
    //목록
    PageResultDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO dto);
    //읽기
    GuestBookDTO read(Long gno);
    //수정
    //삭제
    //검색
    PageResultDTO<GuestBookDTO, GuestBook> search(PageRequestDTO dto, String type, String word);

    //DTO내용을 엔티티로 옮겨담기위한 메소드

    default GuestBook dtoToEntity(GuestBookDTO dto){
        //java8부터 default를 통해 인터페이스에서 직접 구현이 가능함
        return GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        //return new GuestBook(dto.getGno(), dto.getTitle(), dto.getContent(), dto.getWriter());

    }

    default GuestBookDTO entityToDTO(GuestBook entity){
        return GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate()).build();
    }
}
