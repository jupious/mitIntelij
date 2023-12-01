package com.kwak.remote.controller;

import com.kwak.remote.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/rest")
public class ManagerRESTController {

    private ManagerService managerService;

    @PostMapping("/dupcheck/{pno}")
    public boolean dupcheck(@PathVariable("pno") Long pno){
        boolean flag = false;
        if(managerService.dupCheck(pno)){
            flag = true;
        }
        return flag;
    }
}
