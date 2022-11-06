package com.sinnotech.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinnotech.hotel.dto.TestDto;
import com.sinnotech.hotel.service.TestService;

@Controller
public class TestController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private final static String TEST_INDEX = CLIENT_BASE_PATH  + "test/index";
	

	
	@Autowired
	private TestService service;
	
	@RequestMapping(value = "/test/list", method = RequestMethod.GET)
	public ModelAndView index() {
		
		logger.info("1index start");
		
		ModelAndView model = new ModelAndView(TEST_INDEX);
		
		List<TestDto> list = service.finaAll();
		
		System.out.println(list.size());

		if (!list.isEmpty() && list.size() > 0) {
			
			if (list.get(0) != null) {
				System.out.println(list.get(0).getName());
			}
			model.addObject("list", list);
		}

		logger.info("index end");
		
		return model;
	}
	
	@RequestMapping(value = "/admin/test/list", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
		
		logger.info("Admin index start");
		
		ModelAndView model = new ModelAndView("admin/index");

		logger.info("Admin index end");
		
		return model;
	}
}
