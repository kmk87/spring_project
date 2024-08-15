package com.mk.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mk.spring.board.model.vo.Board;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Board> selectBoardList(){
		return sqlSession.selectList("boardMapper.selectBoardList");
	}
	
	
}
