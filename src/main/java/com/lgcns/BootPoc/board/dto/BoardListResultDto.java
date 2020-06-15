package com.lgcns.BootPoc.board.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardListResultDto {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<BoardResultDto> data;
}
