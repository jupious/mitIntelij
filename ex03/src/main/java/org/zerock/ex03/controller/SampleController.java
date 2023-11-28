package org.zerock.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ex03.dto.SampleDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex00")
    public void ex00(){
        log.info("ex00페이지 요청~");
    }

    @GetMapping("/ex1")
    public void ex1(){
        log.info("ex1페이지 요청~");
    }

    @GetMapping("/quiz1")
    public void quiz1(){

    }

    //@RequestParam(name ="num1")
    @PostMapping("/result")
    public void result(int num1, int num2, Model model){
        log.info("뭐가 문제여;;");
        log.info("테스트"+num1+num2);
        int a = num1, b = num2;
        if(num1 > num2){
            a = num2;
            b = num1;
        }
        int sum = 0;
        for(; a <= b; a++){
            sum+=a;
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("sum", sum);

    }

    @GetMapping("/ex2")
    public void ex2(Model model){
        SampleDTO dto = SampleDTO.builder()
                .sno(1L)
                .first("First")
                .last("Last")
                .regTime(LocalDateTime.now())
                .build();
        model.addAttribute("DTO",dto);

        List<SampleDTO> list = new ArrayList<>();
        for(long i = 1; i <= 20; i++){
            SampleDTO dto2 = SampleDTO.builder()
                    .sno(i)
                    .first("First "+i)
                    .last("Last "+i)
                    .regTime(LocalDateTime.now())
                    .build();
            list.add(dto2);
        }
        List<SampleDTO> list2 = IntStream.rangeClosed(21,40).mapToObj(i -> {
            SampleDTO dto3 = SampleDTO.builder()
                    .sno((long)i)
                    .first("First "+i)
                    .last("Last "+i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto3;
        }).collect(Collectors.toList());
        model.addAttribute("list",list);
        model.addAttribute("list2",list2);
        model.addAttribute("date",new Date());

    }

    @GetMapping({"/exLayout1","/exLayout2","/LayoutTest"})
    public void exLayout1(){
        log.info("exLayout..");
    }
}
