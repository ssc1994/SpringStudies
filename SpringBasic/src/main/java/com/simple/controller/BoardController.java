package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.board.service.BoardServiceImpl;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardService;
	
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		return "/service/boardRegister";
	}
	
	@RequestMapping(value = "/boardRegist", method = RequestMethod.POST)
	public String boardRegist(BoardVO vo) {
		boardService.boardRegist(vo);
		return "/service/boardResult";
	}
	
	@RequestMapping("/boardResult")
	public String boardResult() {
		return "/service/boardResult";
	}
	
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		return "/service/boardList";
	}
	
	@RequestMapping("/boardDel")
	public String boardDel(@RequestParam("num") int num) {
		boardService.boardDelete(num);
		System.out.println("딜리트");
		return "redirect:/service/boardList";
	}
	
	

}
