package com.lgcns.BootPoc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("tables")
    public String view(Model model){
        return "tables";
    }

}
