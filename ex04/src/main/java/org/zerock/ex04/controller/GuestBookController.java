package org.zerock.ex04.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/guestbook")
public class GuestBookController {
    @GetMapping({"","/","/list"})
    public String list(){
        log.info("aaa");
        log.info("글목록 요청됨");
        return "/guestbook/list";
    }
}
