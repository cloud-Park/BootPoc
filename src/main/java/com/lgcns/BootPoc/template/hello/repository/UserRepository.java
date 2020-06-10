package com.lgcns.BootPoc.template.hello.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {
    List<UserEntity> findAll();
}
