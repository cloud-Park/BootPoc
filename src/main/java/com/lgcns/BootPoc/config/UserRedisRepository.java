package com.lgcns.BootPoc.config;

import com.lgcns.BootPoc.repository.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<UserEntity,String> {
}
