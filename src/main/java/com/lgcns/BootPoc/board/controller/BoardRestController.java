package com.lgcns.BootPoc.board.controller;

import com.lgcns.BootPoc.board.dto.BoardListResultDto;
import com.lgcns.BootPoc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    @RequestMapping("getList")
    public BoardListResultDto list(HttpServletRequest request){

        BoardListResultDto boardListResultDto = boardService.searchList(request);

        /*
        BoardRequest boardRequest = BoardRequest.mapping(request, 5);

        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " = " + request.getParameter(name));
        }


        int start = boardRequest.getStart();
        int total = 15;
        int length = 10;

        List<BoardResult> list = new ArrayList<>();
        for(int i = 1; i < length + 1; i++) {
            int id = start + i;
            if(id <= total) {
                BoardResult boardResult = new BoardResult();
                boardResult.setId(start + i);
                boardResult.setSubject("Subject_" + (start + i));
                boardResult.setWriter("Admin");
                boardResult.setWrite_date("2020-06-11");
                boardResult.setMod_date("2020-06-11");
                boardResult.setCount(100);
                list.add(boardResult);
            }
        }

        BoardListResult boardListResult = new BoardListResult();
        boardListResult.setDraw(boardRequest.getDraw());
        boardListResult.setRecordsTotal(total);
        boardListResult.setRecordsFiltered(total);
        boardListResult.setData(list);
        */

        return boardListResultDto;
    }
}
