package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.mapper.BoardMapper;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> getBoardList() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getBoardList();
	}

	public List<BoardDTO> getBoard() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getBoard();
	}
	
	public Object updateBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.updateBoard();
	}

	public Object insertBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.insertBoard();
	}

	public Object deleteBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.deleteBoard();
	}

}
