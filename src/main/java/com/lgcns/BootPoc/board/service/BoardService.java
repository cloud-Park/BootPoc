package com.lgcns.BootPoc.board.service;

import com.lgcns.BootPoc.board.dto.*;
import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void insertBoard(BoardDto boardDto){
        commonDao.insert("board.Board.insertBoard", boardDto);
    }

    @Transactional
    public void updateBoard(BoardDto boardDto){
        int update = commonDao.update("board.Board.updateBoard", boardDto);
    }

    @Transactional
    public void deleteBoard(int boardId){
        int del = commonDao.delete("board.Board.deleteBoard", boardId);
    }

    @Transactional
    public void updateViewCnt(int boardId){
        int update = commonDao.update("board.Board.updateViewCnt", boardId);
    }

}
