package com.kwak.remote.controller;

import com.kwak.remote.dto.ManagerDTO;
import com.kwak.remote.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;
    @GetMapping("/main")
    public void mainPage(){  }

    @GetMapping("/register")
    public void registerPage(){  }

    @PostMapping("/register")
    public String register(ManagerDTO managerDTO){
        managerService.insert(managerDTO);
        return "/manager/main";
    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("list",managerService.getData());
    }
}
