package com.lgcns.BootPoc.login.controller;

import com.lgcns.BootPoc.login.dto.LoginUserDto;
import com.mysql.cj.log.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginViewController {

    @GetMapping("/")
    public String index(){
        return "redirect:/tables";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @GetMapping("login")
    public String login(HttpSession session){
        LoginUserDto userDto = (LoginUserDto) session.getAttribute("userInfo");
        if(userDto==null)
            return "login";
        else
            return "redirect:/tables";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("userInfo");
        return "redirect:/login";
    }
}
