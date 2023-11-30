package org.zerock.ex04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class TestDTO {
    private int aa;
    private String bb;
    private Integer cc;
    private Map<String,String> dd;
}
