package com.lgcns.BootPoc.template.hello.repository;

import com.lgcns.BootPoc.template.hello.dto.HelloResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public HelloResponseDto searchById(String id){

        //DB search 로직
        HelloResponseDto helloResponseDto = new HelloResponseDto(id,"Junki Park",29);
        return helloResponseDto;
    }
}
