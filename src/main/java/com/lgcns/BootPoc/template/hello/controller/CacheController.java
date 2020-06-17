package com.lgcns.BootPoc.template.hello.controller;

import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CacheController {
    @PostMapping("/addCache")
    public boolean addCache(@RequestBody Map<String, Object> param){
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
            result = CacheUtil.saveData(key, valMap);
        }
        else{
            result = CacheUtil.saveData(key, param.get("val"));
        }

        return result;
    }
    @PostMapping("/updateCache")
    public boolean updateCache(@RequestBody Map<String, Object> param){
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
            result = CacheUtil.updateData(key, valMap);
        }
        else{
            result = CacheUtil.updateData(key, param.get("val"));
        }

        return result;
    }

}
