package com.lgcns.BootPoc.web;

import com.lgcns.BootPoc.service.HelloService;
import com.lgcns.BootPoc.web.dto.HelloResponseDto;
import com.lgcns.BootPoc.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
