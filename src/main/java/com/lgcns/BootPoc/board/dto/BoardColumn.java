package com.lgcns.BootPoc.board.dto;

import lombok.Data;

import java.util.Map;

@Data
public class BoardColumn {
    private String name;
    private String data;
    private boolean searchable;
    private boolean orderable;
    private Map<String, String> search;
}
