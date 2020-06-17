package com.lgcns.BootPoc.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginContoller {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
