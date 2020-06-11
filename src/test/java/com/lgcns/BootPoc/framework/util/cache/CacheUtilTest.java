package com.lgcns.BootPoc.framework.util.cache;

import com.lgcns.BootPoc.template.hello.repository.UserEntity;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheUtilTest {
    @Autowired RedisTemplate<String, Object> redisTemplate;
    @Test
    public void CacheUtilTest(){

        UserEntity userEntity = UserEntity.builder()
                .id("pjk430")
                .pwd("junki!123")
                .email("pjk430@naver.com")
                .build();

//        CacheUtil.saveData("key1", userEntity);
//        UserEntity userEntity1 = (UserEntity) CacheUtil.searchData("key1");
//        System.out.println(userEntity1.getId());
//
//        userEntity = UserEntity.builder()
//                .id("pjk212")
//                .pwd("jiji")
//                .email("12")
//                .build();
//        CacheUtil.updateData("key1",userEntity);
//        userEntity1 = (UserEntity) CacheUtil.searchData("key1");
//        System.out.println(userEntity1.getId());
//
//        CacheUtil.deleteData("key1");
//        userEntity1 = (UserEntity) CacheUtil.searchData("key1");
//        System.out.println(userEntity1.getId());
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("map1","data1");
        hashMap.put("map2","data2");
        hashMap.put("map3","data3");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("arr1");
        arrayList.add("arr2");
        CacheUtil.saveData("key1", userEntity);
        CacheUtil.saveData("key2", hashMap);
        CacheUtil.saveData("key3", arrayList);

        CacheUtil.searchList();
    }
}
