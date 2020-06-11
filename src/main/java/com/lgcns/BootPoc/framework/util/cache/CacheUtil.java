package com.lgcns.BootPoc.framework.util.cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
public class CacheUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public static boolean saveData(String key,Object data){
        //해당 key가 이미 존재할 경우
        if(redisTemplate.hasKey(key)){
            return false;
        }
        redisTemplate.opsForValue().set(key,data);
        return true;
    }

    public static Object searchData(String key){
        //해당 key 존재하지 않을 때, null 처리 필요
        return redisTemplate.opsForValue().getOperations().keys("*");
    }
    public static Object searchList(){
        Set<String> keys = redisTemplate.keys("*");
        Object obj;
        for(String key : keys){
            System.out.println("key="+key);
            obj = redisTemplate.opsForValue().get(key);
            System.out.println("value="+obj);
            System.out.println(obj.getClass());
        }

        return true;
    }

    public static boolean updateData(String key,Object data){
        //해당 key가 존재하지 않을 때,
        if(searchData(key)==null)
            return false;

        redisTemplate.opsForValue().set(key, data);
        return true;
    }

    public static boolean deleteData(String key){
        //해당 key가 존재하지 않을 때,
        if(searchData(key)==null)
            return false;

        redisTemplate.delete(key);
        return true;
    }

}
