package com.lgcns.BootPoc.admin.controller;

import com.lgcns.BootPoc.admin.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class CacheViewController {
    private final CacheService cacheService;

    @GetMapping("/cache")
    public String searchList(Model model){
        Object obj= cacheService.searchList();
        model.addAttribute("test",obj);
        return "cache-list";
    }

    @GetMapping("/deleteCache/{id}")
    public String delete(@PathVariable String id,Model model){
        System.out.println("key =" +id);
        //del
        cacheService.delete(id);
        //list
        Object obj = cacheService.searchList();
        model.addAttribute("test",obj);
        return "cache-list";
    }

}
