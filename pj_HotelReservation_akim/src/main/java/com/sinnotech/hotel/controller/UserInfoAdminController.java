package com.sinnotech.hotel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinnotech.hotel.dao.UserPageDTO;
import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.service.UserInfoAdminService;
import com.sinnotech.hotel.util.Message;

@Controller
@RequestMapping("/admin/userInfo")
public class UserInfoAdminController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoAdminController.class);

	private final static String Search = ADMIN_BASE_PATH + "userInfo/userInfoSearch";
	private String PreSearch;
	@Autowired
	private UserInfoAdminService userInfoAdminService;
	@Autowired
	private JavaMailSender mailSender;// 위에서 만든 이메일 송신용 config 클래스 선언

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String init(Model model, SetPaging page) {
		logger.info("UserInfoAdminController.userList() - START");
		System.out.println(page.getCurrentPage());

		List<UsersDTO> userInfoInput = new ArrayList<UsersDTO>();
		userInfoInput = userInfoAdminService.getUsersInfoAllList();
		int total = userInfoAdminService.getUsersInfoAllListCount();
		page.setTotal(total);
		int totalPage = (int) page.getTotal();
		page.setStartPage(1);
		page.setCurrentPage(1);
		page.setEndPage(totalPage > 5 ? 5 : (int) totalPage);
		model.addAttribute("page", page);
		model.addAttribute("userInfoList", userInfoInput);

		logger.info("UserInfoAdminController.userList() - END");
		return Search;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, SetPaging page, HttpServletRequest rq) {
		logger.info("UserInfoAdminController.search() - START");
		String searchType=rq.getParameter("searchType");
		String currentPage;
		String searchKeyword=rq.getParameter("searchkeyword");
		if (rq.getParameterValues("searchType") != null) {
			searchType = rq.getParameter("searchType");
			page.setSearchType(searchType);
		}
		if (rq.getParameter("searchKeyword") != null) {
			searchKeyword = rq.getParameter("searchKeyword");
			page.setSearchKeyword(searchKeyword);
		}
		if (rq.getParameter("currentPage") != null) {
			currentPage = rq.getParameter("currentPage");
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		if (PreSearch != null && !PreSearch.equals(page.getSearchKeyword())) {
			page.setCurrentPage(1);
			page.setStartPage(1);
		}
		PreSearch = page.getSearchKeyword();

		UserPageDTO userInfoInput = userInfoAdminService.getUsersInfoList(page);
		model.addAttribute("page", userInfoInput.getPaging());
		model.addAttribute("userInfoList", userInfoInput.getUsersDTOList());

		logger.info("UserInfoAdminController.search() - END");
		return Search;
	}

	@ResponseBody
	@RequestMapping(value = "/passwordReset/{id}", method = RequestMethod.GET)
	public String reset(@PathVariable("id") Integer id, HttpServletRequest rq, HttpServletResponse rs, Model model,
			String email) throws IOException {
		logger.info("UserInfoAdminController.passwordReset() - START");
		// ﻿(required = false) 매개변수의 null의 여부를 지정 -> false == null일 수도 있다.
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
			// 헬퍼를 이용해서 email 연결 정보를 입력하는게 더 편리함
			// 데이터의 양이 많다면 두번쨰 영역을 true를 하면된다 == multipart
			// 마지막은 인코딩 형식 == utf-8
			String newPassword = UUID.randomUUID().toString().substring(0, 5);
			boolean result = userInfoAdminService.updateUserPassword(newPassword, id);
			if (result) {
				msgHelper.setSubject(""); // 이메일의 제목
				msgHelper.setText("임시비밀번호는 " + newPassword + "입니다."); // 이메일의 내용
				msgHelper.setTo(email);
				msgHelper.setFrom("");
				mailSender.send(message);// 메일을 송부
				logger.info("UserInfoAdminController.passwordReset() - END");
				return "Success";
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		logger.info("UserInfoAdminController.passwordReset() - END");
		return "Fail";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model, HttpServletRequest rq,
			RedirectAttributes redirect) throws UnsupportedEncodingException {
		logger.info("UserInfoAdminController.delete() - START");
		String searchType = "", searchKeyword = "", currentPage = "";
		if (rq.getParameter("searchType") != null)
			searchType = rq.getParameter("searchType");
		if (rq.getParameter("searchKeyword") != null)
			searchKeyword = rq.getParameter("searchKeyword");
		if (rq.getParameter("currentPage") != null)
			currentPage = rq.getParameter("currentPage");
		boolean result = userInfoAdminService.deleteUser(id);
		if (result) {
			redirect.addFlashAttribute("message", Message.DELETE_SUCCEED);
		} else {
			redirect.addFlashAttribute("message", Message.DELETE_FALL);
		}
		logger.info("UserInfoAdminController.delete() - END");
		return "redirect:/admin/userInfo/search?searchType=" + searchType + "&searchKeyword=" + searchKeyword
				+ "&currentPage=" + currentPage+"&type=delete";
	}

}
