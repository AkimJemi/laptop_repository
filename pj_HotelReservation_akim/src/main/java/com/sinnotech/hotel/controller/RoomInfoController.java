package com.sinnotech.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.RoomInfoDTO;

@Controller("admin/room/")
public class RoomInfoController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomInfoController.class);

	private final static String ADMIN_ROOMDETAIL_INDEX = ADMIN_BASE_PATH + "roomInfo/adminRoomDetail";


	@RequestMapping(value="detail/{roomId}", method=RequestMethod.GET)
	public String roomDetail(@PathVariable Integer roomId, Model mode, RoomInfoDTO roomInfo) {
		logger.info("roomDetail() - START");
		logger.info("roomDetail() - END");
		return ADMIN_ROOMDETAIL_INDEX;
	}

}
