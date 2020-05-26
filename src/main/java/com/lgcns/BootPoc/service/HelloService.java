package com.lgcns.BootPoc.service;

import com.lgcns.BootPoc.repository.HelloRepository;
import com.lgcns.BootPoc.repository.UserEntity;
import com.lgcns.BootPoc.repository.UserRepository;
import com.lgcns.BootPoc.web.dto.HelloResponseDto;
import com.lgcns.BootPoc.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HelloService {
    private final HelloRepository helloRepository;
    private final UserRepository userRepository;

    public HelloResponseDto searchById(String id){
        return helloRepository.searchById(id);
    }

    public List<UserResponseDto> findAll(){
        return userRepository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
}
