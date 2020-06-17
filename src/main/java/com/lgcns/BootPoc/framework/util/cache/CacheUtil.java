package com.lgcns.BootPoc.framework.util.cache;
import com.lgcns.BootPoc.template.hello.repository.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


@Component
public class CacheUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        //dummyData
        UserEntity userEntity = UserEntity.builder()
                .id("pjk430")
                .pwd("junki!123")
                .email("pjk430@naver.com")
                .build();

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
    }
    public static boolean saveData(String key,Object data) {
        //해당 key가 이미 존재할 경우
        if(redisTemplate.hasKey(key))
            return false;

        redisTemplate.opsForValue().set(key,data);
        return true;
    }

    public static Object searchData(String key){
        //해당 key 존재하지 않을 때, null 처리 필요
        return redisTemplate.opsForValue().get(key);
    }

    public static Object searchList(){
        Set<String> keys = redisTemplate.keys("*");
        Object obj=null;
        ArrayList<HashMap<String,Object>> list= new ArrayList<>();
        HashMap<String, Object> map;

        for(String key : keys){
            DataType dataType = redisTemplate.type(key);
            switch (dataType){
//                case SET:
//                    System.out.println("settype key = "+ key);
//                    break;
//                case HASH:
//                    obj = redisTemplate.opsForHash().entries(key);
//                    break;
                case LIST:
                    obj = redisTemplate.opsForList().range(key,0,-1);
                    break;
                case STRING:
                    obj = redisTemplate.opsForValue().get(key);
                    break;
                case NONE:
                    break;
                case ZSET:
                    obj = redisTemplate.opsForZSet().range(key,0,-1);
                    break;
            }
            map = new HashMap<>();
            map.put(key,obj);
            list.add(map);
            obj=null;
        }

        return list;
    }

    public static boolean updateData(String key,Object data){
        System.out.println("update-key="+key+" / "+"date="+data);
        //해당 key가 존재하지 않을 때, 수정 불가함
        if(!redisTemplate.hasKey(key))
            return false;

        redisTemplate.opsForValue().set(key, data);
        return true;
    }
//
    public static boolean deleteData(String key){
        //해당 key가 존재하지 않을 때 ,
        if(searchData(key)==null)
            return false;

        redisTemplate.delete(key);
        return true;
    }

}
