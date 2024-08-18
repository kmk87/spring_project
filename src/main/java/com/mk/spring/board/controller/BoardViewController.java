package com.mk.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mk.spring.board.model.service.BoardService;
import com.mk.spring.board.model.vo.Board;

@Controller
public class BoardViewController {
	
	
	@Autowired
	BoardService service;
	
	
	@GetMapping("/board")
	public String selectBoardList(Board option, Model model) {
		option.setTotalData(service.selectBoardCount(option));
		List<Board> resultList = service.selectBoardList(option);
		model.addAttribute("resultList",resultList);
		model.addAttribute("paging",option);
		return "/board/list";
	}
	
	
	@GetMapping("/board/create")
	public String createBoardPage() {
		return "/board/create";
	}
	
	@GetMapping("/board/{board_no}")
	public String selectBoardOne(@PathVariable("board_no") int board_no, Model model) {
		Board vo = service.selectBoardOne(board_no);
		model.addAttribute("vo",vo);
		return "/board/detail";
	}
	
	
	@GetMapping("/board/update/{board_no}")
	public String updateBoard(@PathVariable("board_no") int board_no, Model model) {
		Board vo = service.selectBoardOne(board_no);
		model.addAttribute("vo",vo);
		return "/board/update";
	}
	
}
