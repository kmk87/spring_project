package com.mk.spring.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.spring.board.model.dao.BoardDao;
import com.mk.spring.board.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardDao dao;
	
	public List<Board> selectBoardList(){
		List<Board> resultList = new ArrayList<Board>();
		try {
			resultList = dao.selectBoardList();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
