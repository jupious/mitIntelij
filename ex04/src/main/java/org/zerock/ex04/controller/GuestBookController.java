package org.zerock.ex04.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex04.dto.GuestBookDTO;
import org.zerock.ex04.dto.PageRequestDTO;
import org.zerock.ex04.dto.PageResultDTO;
import org.zerock.ex04.dto.TestDTO;
import org.zerock.ex04.entity.GuestBook;
import org.zerock.ex04.service.GuestBookService;

import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/guestbook")
@AllArgsConstructor
public class GuestBookController {

    private GuestBookService service;
    @GetMapping({"","/","/list"})
    public String list(PageRequestDTO pageRequestDTO,String type, String word, Model model){
        log.info("글목록 요청됨");
        if(type==null || word==null){
            log.info("list Request");
            PageResultDTO<GuestBookDTO, GuestBook> data = service.getList(pageRequestDTO);
            model.addAttribute("data",data);
        }else{
            log.info("search Request");
            PageResultDTO<GuestBookDTO, GuestBook> data = service.search(pageRequestDTO,type,word);
            model.addAttribute("data",data);
        }

        return "/guestbook/list";
    }

    @PostMapping("/register")
    public String register(GuestBookDTO guestBookDTO, RedirectAttributes rttr){
        long gno = service.register(guestBookDTO);
        rttr.addFlashAttribute("registerdGno", gno);
        return "redirect:/guestbook/list";
    }

    @GetMapping("/register")
    public void registerPage(){

    }

    @GetMapping("/read")
    public void readPage(Long gno, Model model){
        model.addAttribute("postData", service.read(gno));

    }
















    @GetMapping("/viewtest")
    public void viewtest(Model model){
        model.addAttribute("str1","<h1>컨트롤러에서 보낸거</h1>");
        model.addAttribute("str2","cat.jpg");
        model.addAttribute("str3","bbb");
        model.addAttribute("str4","ccc");
        Map<String,String> map = new HashMap<>();
        map.put("lastname","hong");
        map.put("firstname","gildong");
        log.info(map.get("lastname")); //hong
        model.addAttribute("aaa",new TestDTO(23,"11월",30, map));

    }

}
