package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sinnotech.hotel.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> getBoardList();

	public List<BoardDTO> getBoard();
	
	public Object updateBoard();

	public Object insertBoard();

	public Object deleteBoard();

}
