package com.lgcns.BootPoc.template.hello.controller;

import com.lgcns.BootPoc.template.hello.service.HelloService;
import com.lgcns.BootPoc.template.hello.dto.HelloResponseDto;
import com.lgcns.BootPoc.template.hello.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/api")
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "hello, Welcome";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("id") String id){
        return helloService.searchById(id);
    }

    @GetMapping("/user")
    public List<UserResponseDto> userDto(){
        return helloService.findAll();
    }


}
