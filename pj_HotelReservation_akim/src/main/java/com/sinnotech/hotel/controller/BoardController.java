package com.sinnotech.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.BoardService;
import com.sinnotech.hotel.util.Constants;

@Controller
@RequestMapping("board")
public class BoardController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private final static String BOARDLIST = CLIENT_BASE_PATH + "board/boardList";
	private final static String BOARDDETAIL = CLIENT_BASE_PATH + "board/boardDetail";
	private final static String BOARDFORM = CLIENT_BASE_PATH + "board/boardForm";
//	private String previousContent;
	
	@Autowired
	BoardService boardService;
	
	// 전체 게시글 목록 보기
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String BoardInit(Paging page, Model model) {
		logger.info("문의게시판 리스트 페이지 이동");
		List<BoardDTO> boardDTOList = null;
		boardDTOList = boardService.getBoardList(page);
//		if (page == null || page.getCurrentPage() == null) {
//		} else {
//			if (previousContent != null && !previousContent.equals(page.getContent())) {
//				page.setCurrentPage(null);
//				page.setStartPage(null);
//			}
//			previousContent = page.getContent();
//			boardDTOList = boardService.searchBoardList(page);
//		}
//		model.addAttribute("paging", page);
		model.addAttribute("boardList", boardDTOList);
		return BOARDLIST;
	}
	
	// 해당 게시글 상세 보기
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String boardDetail(Model model,@PathVariable("id") Integer id ) {
		logger.info("문의게시판 상세 페이지 이동");
		BoardDTO boardDTO = boardService.boardDetail(id);
//		BoardDTO comments = boardService.boardDetail(id);
		model.addAttribute("board", boardDTO);
//		model.addAttribute("comments", comments);
		return BOARDDETAIL;
	}
	
	// 새 게시글 입력(게시글 등록)
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String getForm(Model model) {
		logger.info("문의게시판 등록 페이지 이동");
		model.addAttribute("currentTime", LocalDate.now());
		model.addAttribute("form", Constants.INSERT_FORM);
		return BOARDFORM;
	}
	
	// 새 게시글 입력(게시글 등록)
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String postForm(BoardDTO boardDTO,  Model model) {
		logger.info("문의게시판 등록 저장 페이지");
		boardService.insertBoard(boardDTO);
		return "redirect:/board";
	}
	
	// 게시글 수정
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET) 
	public String getUpdate(Model model,@PathVariable("id") Integer id ) {
		logger.info("문의게시판 수정 페이지 이동");
		BoardDTO boardDTO = boardService.boardDetail(id);
		model.addAttribute("board", boardDTO);
		model.addAttribute("form",	"/board/"+ Constants.UPDATE_FORM +"/"+id);
		return BOARDFORM;
	}
	
	// 게시글 수정
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST) 
	public String postUpdate(BoardDTO boardDTO, Model model,@PathVariable("id") Integer id ) {
		logger.info("문의게시판 수정하기");
		boardDTO.setId(id);
		boardService.updateBoard(boardDTO);
		model.addAttribute("board", boardDTO);
		return "redirect:/board/"+id;
	}
	
	// 게시글 삭제
	@RequestMapping(value = "/delete/{id}")
	public String deleteBoard(Model model,@PathVariable("id") Integer id ) {
		logger.info("문의게시판 삭제하기");
		boardService.deleteBoard(id);
		return "redirect:/board";
	}
}