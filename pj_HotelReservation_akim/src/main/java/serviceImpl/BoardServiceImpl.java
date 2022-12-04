package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.BoardDAO;
import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList(Paging page) {
//		page.setTotalCount(boardDAO.getAllBoardCount());
		return boardDAO.getBoardList(page);
	}

	@Override
	public List<BoardDTO> searchBoardList(Paging page) {
		return boardDAO.searchBoardList(page);
	}
	
	@Override
	public BoardDTO boardDetail(Integer id) {
		return boardDAO.boardDetail(id);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		boardDAO.updateBoard(boardDTO);
	}

	@Override
	public void deleteBoard(Integer id) {
		boardDAO.deleteBoard(id);
	}
}
