package com.sinnotech.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.RoomInfoService;

@Controller
@RequestMapping("admin/room/")
public class AdminRoomInfoController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBookManagementController.class);

	private final static String ADMIN_ROOMINFO_LIST = ADMIN_BASE_PATH + "roomInfo/getRoomInfoList";
	private final static String ADMIN_ROOMINFO_DETAIL = ADMIN_BASE_PATH + "roomInfo/getRoomInfoDetail";
	private final static String ADMIN_ROOMINFO_INSERT = ADMIN_BASE_PATH + "roomInfo/getRoomInfoInsert";

	@Autowired
	private RoomInfoService roomInfoService;
	
	@RequestMapping(value = "roominfolist", method = RequestMethod.GET)
	public ModelAndView getRoomInfoList(Paging paging) {
		
		System.out.println("11");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_LIST);
		List<AdminRoomInfoDTO> roomInfoList = roomInfoService.getRoomInfoList();
		model.addObject("roomInfoList", roomInfoList);
		
		return model;
	}
	
	@RequestMapping(value = "detail/{room_id}", method = RequestMethod.GET)
	public ModelAndView getRoomInfoDetail(@PathVariable("room_id") int room_id) {
		
		System.out.println("12");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_DETAIL);
		AdminRoomInfoDTO roomInfoDetail = roomInfoService.getRoomInfoDetail(room_id);
		model.addObject("roomInfoDetail", roomInfoDetail);
		
		System.out.println("roomInfoDetail"+roomInfoDetail.toString());
		
		return model;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView getRoomInfoInsert() {
		
		System.out.println("13");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_INSERT);
		
		return model;
	}
	
	@RequestMapping(value = "realinsert", method = RequestMethod.POST)
	public ModelAndView getRoomInfoRealInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		
		System.out.println("14");
		roomInfoService.getRoomInfoInsert(adminRoomInfoDTO);
		ModelAndView model = new ModelAndView("redirect:/admin/room/roominfolist");
		model.addObject("roomInfoDetail", adminRoomInfoDTO);
		
		try {
			adminRoomInfoDTO.getUpload_file().transferTo(new File("\\resources\\images\\" + adminRoomInfoDTO.getImages()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
}


