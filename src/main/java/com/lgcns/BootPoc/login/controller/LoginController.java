package com.lgcns.BootPoc.login.controller;

import com.lgcns.BootPoc.login.dto.LoginUserDto;
import com.lgcns.BootPoc.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @PostMapping("login")
    public boolean login(@RequestBody LoginUserDto userDto, HttpSession session){
        log.info("userDto="+userDto);
        LoginUserDto user = loginService.searchByEmail(userDto.getEmail());
        if (user != null) {
            if (userDto.getPasswd().equals(user.getPasswd())){
                session.setAttribute("userInfo", user);
                return true;
            }
        }
        return false;
    }
    @PostMapping("register")
    public boolean register(@RequestBody LoginUserDto userDto){
        log.info("userDto="+userDto);
        return loginService.save(userDto);
    }

    @GetMapping("duplicateCheck")
    public boolean duplicateCheck(@RequestParam String email){
        log.info("email="+email);
        if(loginService.searchByEmail(email)!=null)
            return true;
        else
            return false;
    }


    @GetMapping("delUser")
    public void del(){
        loginService.delete("123123@naver.com");
        loginService.delete("123");
        loginService.delete("1231231");
    }

}
