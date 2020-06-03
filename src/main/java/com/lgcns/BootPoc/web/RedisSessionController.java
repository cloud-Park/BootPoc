package com.lgcns.BootPoc.web;

import com.lgcns.BootPoc.config.UserRedisRepository;
import com.lgcns.BootPoc.repository.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
