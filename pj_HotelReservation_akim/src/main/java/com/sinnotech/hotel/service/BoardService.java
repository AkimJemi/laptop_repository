package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> getBoardList();
	
	public List<BoardDTO> getBoard();
	
	public Object updateBoard();

	public Object insertBoard();

	public Object deleteBoard();
	
}
