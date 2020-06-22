package com.lgcns.BootPoc.board.controller;

import com.lgcns.BootPoc.board.dto.BoardDto;
import com.lgcns.BootPoc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("tables")
    public String view(){
        return "tables";
    }

    @GetMapping("detail/{boardId}")
    public ModelAndView detail(@PathVariable int boardId){
        ModelAndView mv = new ModelAndView();
        BoardDto boardDto = boardService.searchById(boardId);
        boardService.updateViewCnt(boardId);

        mv.setViewName("detail");
        mv.addObject("details", boardDto);

        return mv;
    }

    @GetMapping("boardRegister")
    public String boardRegister(@ModelAttribute BoardDto boardDto){
        return "boardRegister";
    }

    @PostMapping("insertBoard")
    public String insertBoard(BoardDto boardDto){
        boardService.insertBoard(boardDto);
        return "redirect:/tables";
    }

    @GetMapping("updateBoard/{boardId}")
    public String edit(@PathVariable int boardId, Model model, @ModelAttribute BoardDto boardDto){
        BoardDto dto = boardService.searchById(boardId);
        model.addAttribute("details", dto);

        return "update";
    }

    @PostMapping("updateBoard")
    public String updateBoard(BoardDto boardDto){
        boardService.updateBoard(boardDto);
        return "redirect:/tables";
    }

    @GetMapping("deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable int boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/tables";
    }
}
