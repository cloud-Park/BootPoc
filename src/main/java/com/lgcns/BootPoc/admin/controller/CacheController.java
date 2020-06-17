package com.lgcns.BootPoc.admin.controller;

import com.lgcns.BootPoc.admin.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CacheController {
    private final CacheService cacheService;

    @PostMapping("/addCache")
    public boolean save(@RequestBody Map<String, Object> param){
        boolean result;
        System.out.println(param);
        String key = (String)param.get("key");

        //여러개
        if((int)param.get("size")>1){
            Map<String, String> valMap = (Map<String,String>) param.get("val");
            for(String innerKey : valMap.keySet()){
                String value = valMap.get(innerKey);
                System.out.println(innerKey+"/"+value);
            }
            result = cacheService.save(key,valMap);
        }
        else{
            result = cacheService.save(key,param.get("val"));
        }

        return result;
    }
    @PostMapping("/updateCache")
    public boolean update(@RequestBody Map<String, Object> param){
        boolean result;
        System.out.println(param);
        String key = (String)param.get("key");

        if((int)param.get("size")>1){
            //여러개
            Map<String, String> valMap = (Map<String,String>) param.get("val");
            for(String innerKey : valMap.keySet()){
                String value = valMap.get(innerKey);
                System.out.println(innerKey+"/"+value);
            }
            result = cacheService.update(key,valMap);

        }
        else {
            result = cacheService.update(key, param.get("val"));
        }

        return result;
    }

}
