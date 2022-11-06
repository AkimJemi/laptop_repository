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
public class roomController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(roomController.class);
	
	private final static String ROOM_MAP = CLIENT_BASE_PATH  + "room/Deluxe";
	
	//@Autowired
	//private TestService service;
	
	@RequestMapping(value = "/room/Deluxe", method = RequestMethod.GET)
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView(ROOM_MAP);
		
		//List<TestDto> list = service.finaAll();
		
		return model;
	}
}
