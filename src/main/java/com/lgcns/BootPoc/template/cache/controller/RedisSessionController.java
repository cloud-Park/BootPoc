package com.lgcns.BootPoc.template.cache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RedisSessionController {

    @GetMapping("/sessionStore")
    public String sessionStore(HttpSession session){
        //key : pjk430 / value : 박준기
        session.setAttribute("pjk430","박준기");
        return "success";
    }

    @GetMapping("/redisSessionConfirm")
    public String redisSessionConfirm(HttpSession session){

        String result = (String)session.getAttribute("pjk430");
        return result;
    }
}
