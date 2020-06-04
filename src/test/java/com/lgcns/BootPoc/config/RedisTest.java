package com.lgcns.BootPoc.config;

import com.lgcns.BootPoc.repository.UserEntity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private UserRedisRepository userRedisRepository;

    @After
    public void tearDown() throws Exception{
//        userRedisRepository.deleteAll();
    }

    @Test
    public void userSearchTest(){
        String id = "pjk430";
        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .pwd("junki!123")
                .email("pjk430@naver.com")
                .build();

        userRedisRepository.save(userEntity);


        UserEntity savedUserEntity = userRedisRepository.findById(id).get();
        assertThat(savedUserEntity.getEmail()).isEqualTo("pjk430@naver.com");

    }
}
