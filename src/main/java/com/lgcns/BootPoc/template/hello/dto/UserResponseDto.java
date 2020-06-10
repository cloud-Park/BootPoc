package com.lgcns.BootPoc.template.hello.dto;

import com.lgcns.BootPoc.template.hello.repository.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String id;
    private String pwd;
    private String email;

    public UserResponseDto(UserEntity entity){
        this.id = entity.getId();
        this.pwd = entity.getPwd();
        this.email = entity.getEmail();
    }

    @Builder
    public UserResponseDto(String id, String pwd, String email){
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }
}
