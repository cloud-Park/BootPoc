package com.lgcns.BootPoc.web.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter @Setter
public class HelloResponseDto {
    private final String id;
    private final String name;
    private final int age;
}
