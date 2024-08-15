package com.mk.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mk.spring.board.model.service.BoardService;
import com.mk.spring.board.model.vo.Board;

@Controller
public class BoardViewController {
	
	
	@Autowired
	BoardService service;
	
	
	@GetMapping("/board")
	public String selectBoardList(Model model) {
		List<Board> resultList = service.selectBoardList();
		model.addAttribute("resultList",resultList);
		return "/board/list";
	}
	
}
