package com.lgcns.BootPoc.template.hello.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@ToString
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
