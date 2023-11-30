package org.zerock.ex04.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.ex04.dto.GuestBookDTO;
import org.zerock.ex04.dto.PageRequestDTO;
import org.zerock.ex04.dto.PageResultDTO;
import org.zerock.ex04.entity.GuestBook;
import org.zerock.ex04.entity.QGuestBook;
import org.zerock.ex04.repository.GuestBookRepository;

import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class GuestBookServiceImpl implements GuestBookService{

    private final GuestBookRepository guestBookRepository;
    @Override
    public Long register(GuestBookDTO dto) {
        log.info("등록서비스 요청됨");
        GuestBook entity = dtoToEntity(dto);
        guestBookRepository.save(entity);
        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO dto) {
        Page<GuestBook> result = guestBookRepository.findAll(dto.getPageable(Sort.by("gno").descending()));
        return new PageResultDTO<>(result,(this::entityToDTO));
    }

    @Override
    public GuestBookDTO read(Long gno) {
        Optional<GuestBook> result = guestBookRepository.findById(gno);
        GuestBookDTO guestBookDTO = null;
        if(result.isPresent()){
            guestBookDTO = entityToDTO(result.get());
        }
        return guestBookDTO;
    }

    @Override
    public PageResultDTO<GuestBookDTO, GuestBook> search(PageRequestDTO dto, String type, String word) {
        String[] typeArr = type.split("");
        QGuestBook qGuestBook = QGuestBook.guestBook;
        BooleanBuilder builder = new BooleanBuilder();
        String trimmedWord = word.trim();
        BooleanExpression dummy = qGuestBook.gno.isNotNull();
        BooleanExpression checkTitle = qGuestBook.title.contains(trimmedWord);
        BooleanExpression checkContent = qGuestBook.content.contains(trimmedWord);
        BooleanExpression checkWriter = qGuestBook.writer.contains(trimmedWord);

        int typeCounter = 0;
        for(String t : typeArr){
            if(t.equals("T")){
                if(typeCounter == 0){
                    builder.and(checkTitle);
                    typeCounter+=1;
                }else{
                    builder.or(checkTitle);
                    typeCounter+=1;
                }
            }else if(t.equals("C")) {
                if(typeCounter == 0){
                    builder.and(checkContent);
                    typeCounter+=1;
                }else{
                    builder.or(checkContent);
                    typeCounter+=1;
                }
            }else if(t.equals("W")) {
                if(typeCounter == 0){
                    builder.and(checkWriter);
                    typeCounter+=1;
                }else{
                    builder.or(checkWriter);
                    typeCounter+=1;
                }
            }
        }
        Page<GuestBook> res = guestBookRepository.findAll(builder, dto.getPageable(Sort.by("gno").descending()));


        return new PageResultDTO<GuestBookDTO,GuestBook>(res,(this::entityToDTO));
    }
}
