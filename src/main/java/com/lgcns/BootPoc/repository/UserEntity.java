package com.lgcns.BootPoc.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("userEntity")
@Getter
@NoArgsConstructor
public class UserEntity implements Serializable {

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
