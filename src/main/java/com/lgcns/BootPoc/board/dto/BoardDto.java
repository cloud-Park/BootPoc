package com.lgcns.BootPoc.board.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int boardId;
    private String subject;
    private String content;
    private int viewCnt;
    private String writer;
    private String writeDate;
    private String modDate;
}
