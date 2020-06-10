package com.lgcns.BootPoc.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String id;
    private String pwd;
    private String email;

    @Builder
    public UserRequestDto(String id, String pwd, String email){
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }

    public UserEntity toEntity(){
        return;
    }
}
