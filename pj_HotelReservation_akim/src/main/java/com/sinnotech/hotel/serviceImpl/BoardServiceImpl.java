package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.BoardDAO;
import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {

		return boardDAO.getBoardList();
	}
	
	@Override
	public List<BoardDTO> getBoard() {
		
		return boardDAO.getBoardList();
	}

	@Override
	public Object updateBoard() {
		return null;
	}

	@Override
	public Object insertBoard() {
		return null;
	}

	@Override
	public Object deleteBoard() {
		return null;
	}


}
