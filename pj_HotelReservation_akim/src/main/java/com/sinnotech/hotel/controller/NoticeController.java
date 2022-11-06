package com.sinnotech.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.service.NoticeService;

@Controller
@RequestMapping("admin/notice/")

public class NoticeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	private final static String INDEX_LIST = ADMIN_BASE_PATH + "notice/list";
	private final static String INDEX_WRITE = ADMIN_BASE_PATH + "notice/write";
	private final static String INDEX_DETAIL = ADMIN_BASE_PATH + "notice/detail";
	private final static String INDEX_UPDATE = ADMIN_BASE_PATH + "notice/update";

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list")
	public String noticeList(Model model) {
		logger.info("게시판 리스트 페이지 이동");
		List<NoticeDTO> noticeList = noticeService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return INDEX_LIST;
	}

	@RequestMapping(value = "write")
	public String noticewrite(Model model) {
		logger.info("게시판 글쓰기 페이지 이동");

		// 현재날짜 취득
		model.addAttribute("currentTime", LocalDate.now());
		return INDEX_WRITE;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String noticeSave(NoticeDTO notice) {
		logger.info("게시물 입력후 게시판 리스트 페이지 이동");
		noticeService.write(notice);
		return "redirect:/admin/notice/list";
	}

	@RequestMapping(value = "detail/{noticeId}", method = RequestMethod.GET)
	public String noticeDetail(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시물 상세 페이지 이동");
		NoticeDTO detail = noticeService.getNotice(noticeId);
		model.addAttribute("notice", detail);
		return INDEX_DETAIL;
	}

	@RequestMapping(value = "update/{noticeId}", method = RequestMethod.GET)
	public String noticeUpdate(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시물 수정 페이지 이동");
		NoticeDTO detail = noticeService.getNotice(noticeId);
		model.addAttribute("notice", detail);
		return INDEX_UPDATE;
	}

	@RequestMapping(value = "update/{noticeId}", method = RequestMethod.POST)
	public String noticeDoUpdate(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시물 수정작업 리스트로 이동");
		NoticeDTO detail = noticeService.updateNotice(noticeId);
		model.addAttribute("notice", detail);
		return detail != null ? INDEX_LIST : INDEX_UPDATE;
	}
}
