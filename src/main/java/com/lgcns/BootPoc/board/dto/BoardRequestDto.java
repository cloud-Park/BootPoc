package com.lgcns.BootPoc.board.dto;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BoardRequestDto {

    private int draw;
    private int start;
    private int length;
    private Map<String, String> search;
    private List<BoardColumn> columns;
    private List<BoardOrder> order;

    public static BoardRequestDto mapping(HttpServletRequest request, int columnSize) {

        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setDraw(Integer.parseInt(request.getParameter("draw"), 10));
        boardRequestDto.setStart(Integer.parseInt(request.getParameter("start"), 10));
        boardRequestDto.setLength(Integer.parseInt(request.getParameter("length"), 10));

        Map<String, String> search = new HashMap<>();
        search.put("value", request.getParameter("search[value]"));
        search.put("regex", request.getParameter("search[regex]"));
        boardRequestDto.setSearch(search);

        for(int i = 0; i < columnSize + 1; i++) {
            BoardColumn boardColumn = new BoardColumn();
            boardColumn.setName(request.getParameter("columns[" + i + "][name]"));
            boardColumn.setData(request.getParameter("columns[" + i + "][data]"));
            boardColumn.setOrderable(Boolean.parseBoolean(request.getParameter("columns[" + i + "][orderable]")));
            boardColumn.setSearchable(Boolean.parseBoolean(request.getParameter("columns[" + i + "][searchable]")));

            Map<String, String> searchColumn = new HashMap<>();
            searchColumn.put("value", request.getParameter("columns[" + i + "][search][value]"));
            searchColumn.put("regex", request.getParameter("columns[" + i + "][search][regex]"));
            boardColumn.setSearch(searchColumn);
        }

        return boardRequestDto;
    }

}
