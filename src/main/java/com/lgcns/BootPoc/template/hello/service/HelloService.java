package com.lgcns.BootPoc.template.hello.service;

import com.lgcns.BootPoc.template.hello.repository.HelloRepository;
import com.lgcns.BootPoc.template.hello.repository.UserRepository;
import com.lgcns.BootPoc.template.hello.dto.HelloResponseDto;
import com.lgcns.BootPoc.template.hello.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HelloService {
    private final HelloRepository helloRepository;
    private final UserRepository userRepository;

    @Autowired
    private final SqlSessionTemplate sqlSessionTemplate;

    public HelloResponseDto searchById(String id){
        return helloRepository.searchById(id);
    }

    public List<UserResponseDto> findAll(){
        List<UserResponseDto> list = sqlSessionTemplate.selectList("com.lgcns.BootPoc.template.hello.repository.UserRepository.findAll");
        System.out.println(list);
        return list;

        //return userRepository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
}
