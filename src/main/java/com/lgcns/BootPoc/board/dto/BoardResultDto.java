package com.lgcns.BootPoc.board.dto;

import lombok.Data;

@Data
public class BoardResultDto {
    private int boardId;
    private String subject;
    private String writer;
    private String writeDate;
    private String modDate;
    private int viewCnt;
}
