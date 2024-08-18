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
	
	// 페이징
	public int selectBoardCount(Board option) {
		int result = 0;
		try {
			
			result = dao.selectBoardCount(option);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 게시글 조회 + 페이징
	public List<Board> selectBoardList(Board option){
		List<Board> resultList = new ArrayList<Board>();
		try {
			resultList = dao.selectBoardList(option);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	// 게시글 등록
	public int createBoard(Board vo) {
		int result = 0;
		try {
			result = dao.createBoard(vo);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 게시글 상세조회
	public Board selectBoardOne(int board_no) {
		Board vo = null;
		try {
			vo = dao.selectBoardOne(board_no);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// 게시글 수정
	public int updateBoard(Board vo) {
		int result = 0;
		try {
			result = dao.updateBoard(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시글 삭제
	public int deleteBoard(int board_no) {
		int result = 0;
		try {
			result = dao.deleteBoard(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}
