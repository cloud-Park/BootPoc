package com.lgcns.BootPoc.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @GetMapping("/")
    public String index(){
        return "redirect:/tables";
    }

    @GetMapping("registerPage")
    public String register(){
        return "register";
    }

    @GetMapping("loginPage")
    public String login(){
        return "login";
    }
}
