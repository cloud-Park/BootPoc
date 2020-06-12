package com.lgcns.BootPoc.template.hello.controller;

import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import com.lgcns.BootPoc.template.hello.repository.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class CacheViewController {
    @GetMapping("cache")
    public String view(Model model){
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

        Object obj= CacheUtil.searchList();
        model.addAttribute("test",obj);
        return "cache";
    }
}
