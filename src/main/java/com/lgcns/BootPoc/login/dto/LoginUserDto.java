package com.lgcns.BootPoc.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class LoginUserDto implements Serializable {
    private int userId;
    private String email;
    private String name;
    private String passwd;

    @Builder
    public LoginUserDto(int userId, String email, String name, String passwd){
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.passwd = passwd;
    }
}
