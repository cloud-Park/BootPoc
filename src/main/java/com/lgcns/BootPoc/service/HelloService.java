package com.lgcns.BootPoc.service;

import com.lgcns.BootPoc.repository.HelloRepository;
import com.lgcns.BootPoc.web.dto.HelloResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HelloService {
    private final HelloRepository helloRepository;

    public HelloResponseDto searchById(String id){
        return helloRepository.searchById(id);
    }
}
