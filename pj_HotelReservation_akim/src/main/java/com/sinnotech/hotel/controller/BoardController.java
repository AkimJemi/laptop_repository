package com.sinnotech.hotel.controller;

import java.util.List;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinnotech.hotel.dao.BoardDAO;
import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.service.BoardService;

@Controller

public class BoardController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	private final static String BOARDLIST_FORM = CLIENT_BASE_PATH+"board/boardList";
	private final static String GETBOARD_FORM = CLIENT_BASE_PATH+"board/getBoard";
	private final static String INSERTBOARD_FORM = CLIENT_BASE_PATH+"board/insertBoard";
	
	@Autowired
	BoardService boardService;
	
	// 전체 게시글 목록 보기
	@RequestMapping(value = "/board")
	public String BoardInit(BoardDTO boardDTO, Model model) {
		logger.info("문의게시판 리스트 페이지 이동");
		LocalDate now = LocalDate.now();
		List<BoardDTO> boardDTOList = boardService.getBoardList();
		model.addAttribute("boardList", boardDTOList);
		System.out.println(now);
		return BOARDLIST_FORM;
	}
	
	// 해당 게시글 상세 보기
	@RequestMapping(value = "/getBoard")
	public String getBoard(BoardDTO boardDTO, Model model) {
		List<BoardDTO> boardDTOList = boardService.getBoard();
		model.addAttribute("getboard", boardDTOList);
		return GETBOARD_FORM;
	}
	
	// 게시글 수정
	@RequestMapping(value = "/updateBoard")
	public String updateBoard(BoardDTO boardDTO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDTO);
		return BOARDLIST_FORM;
	}
	
	// 새 게시글 입력(게시글 등록)
	@RequestMapping(value = "/insertBoard")
	public String insertBoard(BoardDTO boardDTO, BoardDAO boardDAO, Model model) {
		logger.info("문의게시판 등록 페이지 이동");
		model.addAttribute("currentTime", LocalDate.now());
		boardDAO.insertBoard(boardDTO);
		return INSERTBOARD_FORM;
	}
	
	// 게시글 삭제
	@RequestMapping(value = "/deleteBoard")
	public String deleteBoard(BoardDTO boardDTO, BoardDAO boardDAO) {
		boardDAO.deleteBoard(boardDTO);
		return BOARDLIST_FORM;
	}
	
}