package com.sinnotech.hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.util.PathCollection;
import com.sinnotech.hotel.util.Util;

@Controller
@RequestMapping("admin")
public class AdminHomeController extends BaseController implements PathCollection {

	private static final Logger logger = LoggerFactory.getLogger(AdminHomeController.class);

	private final String ADMIN_HOME_PAGE = ((String[]) ADMIN_BASE_PATH.split("/"))[0];

	@Autowired
	private BookService bookService;

	@RequestMapping("")
	public String home(Model model, Paging page, HttpServletRequest rq) {
		logger.info("home() - START");
		if (page == null || page.getCurrentPage() == null)
			page.setCurrentPage(null);
		BookInfo bookInfo = bookService.adminHomeBookInfo(page);
		model.addAttribute(BOOKLIST, bookInfo.getBookDTOList());
		model.addAttribute(PAGING, bookInfo.getPaging());
		Util.setGET_RETURN_KIND(rq, $ADMIN, page);
		logger.info("home() - END");
		return ADMIN_HOME_PAGE;
	}
}