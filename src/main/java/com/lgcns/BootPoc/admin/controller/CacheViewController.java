package com.lgcns.BootPoc.admin.controller;

import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CacheViewController {
    @GetMapping("/cache")
    public String view(Model model){

        Object obj= CacheUtil.searchList();
        model.addAttribute("test",obj);
        return "cache-list";
    }

    @GetMapping("/deleteCache/{id}")
    public String deleteCache(@PathVariable String id,Model model){
        //js에서 ajax로 처리로 변경예정--> 성공 코드만 받고 재조회하지않고, ui만 수정
//        String delKey = httpServletRequest.getParameter("delKey");
        System.out.println("key =" +id);

        CacheUtil.deleteData(id);

        Object obj = CacheUtil.searchList();
        model.addAttribute("test",obj);
        return "cache-list";
    }

}
