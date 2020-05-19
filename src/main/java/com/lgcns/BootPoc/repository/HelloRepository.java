package com.lgcns.BootPoc.repository;

import com.lgcns.BootPoc.web.dto.HelloResponseDto;
import org.springframework.stereotype.Repository;


public class HelloRepository {

    public HelloResponseDto searchById(String id){
        //DB search 로직
        HelloResponseDto helloResponseDto = new HelloResponseDto(id,"Junki Park",29);
        return helloResponseDto;
    }
}
