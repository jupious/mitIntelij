package org.zerock.ex04.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestBookDTO {

    private Long gno;
    private String title, content, writer;
    private LocalDateTime regDate,modDate;
}
