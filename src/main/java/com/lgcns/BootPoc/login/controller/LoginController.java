package com.lgcns.BootPoc.login.controller;

import com.lgcns.BootPoc.login.dto.LoginUserDto;
import com.lgcns.BootPoc.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @GetMapping("login")
    public boolean login(@RequestParam LoginUserDto userDto){
        if(loginService.searchByEmail(userDto.getEmail())==null)
            return false;
        return true;
    }
    @GetMapping("register")
    public boolean register(@RequestParam LoginUserDto userDto){
        return loginService.save(userDto);
    }
}
