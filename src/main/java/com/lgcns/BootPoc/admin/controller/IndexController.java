package com.lgcns.BootPoc.admin.controller;

import com.lgcns.BootPoc.admin.service.CacheService;
import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

/**
 * 페이지 전환
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final CacheService cacheService;

    @GetMapping("/addCachePage")
    public String addCachePage(Model model){
        HashMap<String,String> cache = new HashMap<>();
        cache.put("type","add");
        model.addAttribute("cache", cache);
        return "cache-update";
    }
    @GetMapping("/updateCachePage/{id}")
    public String updateCachePage(@PathVariable String id, Model model){
        log.info("updateCachePage id =" +id);

        Object obj = cacheService.searchByKey(id);
        log.info("updateCachePage searchData =" +obj);

        HashMap<String, Object> cache = new HashMap<>();
        cache.put("key",id);
        cache.put("value",obj);
        cache.put("type","update");
        model.addAttribute("cache",cache);
        return "cache-update";
    }
}
