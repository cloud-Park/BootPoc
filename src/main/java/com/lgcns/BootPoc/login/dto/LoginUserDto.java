package com.lgcns.BootPoc.login.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginUserDto {
    private String email;
    private String userName;
    private String pwd;

    @Builder
    public LoginUserDto(String email, String userName, String pwd){
        this.email = email;
        this.userName = userName;
        this.pwd = pwd;
    }
}
