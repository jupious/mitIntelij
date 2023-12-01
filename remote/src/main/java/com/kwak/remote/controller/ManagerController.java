package com.kwak.remote.controller;

import com.kwak.remote.dto.ManagerDTO;
import com.kwak.remote.service.ManagerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/manager")
@Log4j2
public class ManagerController {

    private ManagerService managerService;
    @GetMapping("/main")
    public void mainPage(){
        log.info("한글깨지냐?");
    }

    @GetMapping("/register")
    public void registerPage(){


    }

    @PostMapping("/register")
    public String register(ManagerDTO managerDTO, Model model){
        String status;
        if(!managerService.insert(managerDTO)){
            model.addAttribute("fail",true);
            status="/manager/register";
        }else{
            status="/manager/main";
        }

        return status;
    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("list",managerService.getDataList());
    }
}
