package com.lgcns.BootPoc.admin.controller;

import com.lgcns.BootPoc.admin.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CacheController {
    private final CacheService cacheService;

    @PostMapping("/addCache")
    public boolean save(@RequestBody Map<String, Object> param){
        boolean result;
        String key = (String)param.get("key");
        log.info("saveMethod param check="+param);
        //여러개
        if((int)param.get("size")>1){
            Map<String, String> valMap = (Map<String,String>) param.get("val");
            for(String innerKey : valMap.keySet()){
                String value = valMap.get(innerKey);
                log.info("saveMethod key/val check="+innerKey+"/"+value);
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
        String key = (String)param.get("key");
        log.info("updateMethod param check="+param);

        if((int)param.get("size")>1){
            //여러개
            Map<String, String> valMap = (Map<String,String>) param.get("val");
            for(String innerKey : valMap.keySet()){
                String value = valMap.get(innerKey);
                log.info("saveMethod key/val check="+innerKey+"/"+value);
            }
            result = cacheService.update(key,valMap);

        }
        else {
            result = cacheService.update(key, param.get("val"));
        }

        return result;
    }

}
