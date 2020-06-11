package com.lgcns.BootPoc.template.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("tables")
    public String view(){
        return "tables";
    }

}
