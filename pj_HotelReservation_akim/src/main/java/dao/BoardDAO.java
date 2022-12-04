package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.mapper.BoardMapper;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> getBoardList(Paging paging) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getBoardList(paging);
	}

	public List<BoardDTO> searchBoardList(Paging paging) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchBoardList(paging);
	}

	public BoardDTO boardDetail(Integer id) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardDetail(id);
	}
	
	public void boardForm(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
	}

	public void updateBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.updateBoard(boardDTO);
	}

	public void deleteBoard(Integer id) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.deleteBoard(id);
	}

	public void insertBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.insertBoard(boardDTO);
	}

	public Integer getAllBoardCount() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getAllBoardCount();
	}
}
