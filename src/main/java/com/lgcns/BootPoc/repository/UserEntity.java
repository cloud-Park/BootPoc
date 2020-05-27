package com.lgcns.BootPoc.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserEntity {

    private String id;
    private String pwd;
    private String email;

    @Builder
    public UserEntity (String id, String pwd, String email){
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }
}
