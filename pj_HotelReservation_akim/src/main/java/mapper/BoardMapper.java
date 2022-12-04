package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.Paging;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> getBoardList(Paging paging);
	
	public List<BoardDTO> searchBoardList(Paging paging);

	public BoardDTO boardDetail(@Param("id") Integer id);
	
	public void insertBoard(BoardDTO boardDTO);

	public void updateBoard(BoardDTO boardDTO);

	public void deleteBoard(@Param("id") Integer id);

	public Integer getAllBoardCount();
}
