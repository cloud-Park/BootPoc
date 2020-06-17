package com.lgcns.BootPoc.board.service;

import com.lgcns.BootPoc.board.dto.*;
import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final CommonDao commonDao;

    public BoardListResultDto searchList(HttpServletRequest request){

        BoardRequestDto boardRequestDto = BoardRequestDto.mapping(request, 5);
        List<BoardResultDto> list = commonDao.selectList("board.Board.searchList", boardRequestDto);

//        int start = boardRequestDto.getStart();
        int total = commonDao.select("board.Board.total");
//        int length = boardRequestDto.getLength();

        BoardListResultDto boardListResultDto = new BoardListResultDto();
        boardListResultDto.setDraw(boardRequestDto.getDraw());
        boardListResultDto.setRecordsTotal(total);
        boardListResultDto.setRecordsFiltered(total);
        boardListResultDto.setData(list);

        return boardListResultDto;
    }

    public BoardDto searchById(int boardId){
        BoardDto boardDto = commonDao.select("board.Board.searchById", boardId);
        return boardDto;
    }

    public void insertBoard(BoardDto boardDto){
        boardDto.getSubject();
        boardDto.getContent();
        boardDto.getWriter();
        commonDao.insert("board.Board.insertBoard", boardDto);
    }

}
