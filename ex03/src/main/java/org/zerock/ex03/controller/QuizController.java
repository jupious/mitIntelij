package org.zerock.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.ex03.dto.Quiz2VO;

import java.util.Date;

@Controller
public class QuizController {

    @GetMapping("/quiz/quiz2")
    public void quiz2(){

    }
    @PostMapping("/quiz/quiz2")
    public String quiz2Post(@RequestParam(name = "todo") String todo, Model model){
        Quiz2VO vo = new Quiz2VO(todo, new Date());
        model.addAttribute("data", vo);
        return "quiz/quiz3";
    }

    @GetMapping("/quiz/layout")
    public void layout(){

    }


}
