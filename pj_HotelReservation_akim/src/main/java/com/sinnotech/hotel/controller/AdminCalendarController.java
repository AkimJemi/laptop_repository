package com.sinnotech.hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.dto.BookingsDTO;
import hotel.dto.Paging;
import hotel.dto.RoomDTO;
import hotel.helper.BookHelper;
import hotel.service.BookService;
import hotel.service.RoomService;
import hotel.util.JsonMessage;
import hotel.util.Message;
import hotel.util.PathCollection;
import hotel.util.Util;

@Controller
@RequestMapping("admin/calendar")
public class AdminCalendarController extends BaseController implements PathCollection {
	private final String CALENDAR_BASE = ADMIN_BASE_PATH + BOOK$ + "adminCalendar";

	private String previousContent;

	@Autowired
	private BookService bookService;

	@Autowired
	private RoomService roomService;

	@RequestMapping("")
	public String calendar(Model model, Paging page) {
		roomSearch(page, model);
		return CALENDAR_BASE;
	}

	@RequestMapping("{roomID}")
	public String calendar(Model model, @PathVariable("roomID") Integer roomID, Paging page, HttpServletRequest rq) {
		System.out.println(page.getDeleteFlag());
		roomSearch(page, model);
		if (roomID != null) {
			model.addAttribute("roomInfo", roomService.searchRoomInfoDetailByRoomID(roomID));
			model.addAttribute("bookingDates", bookService.searchBookDateByRoomID(roomID));
		}
		Util.setGET_RETURN_KIND(rq, $ADMIN$CALENDAR$ + roomID, page);
		return CALENDAR_BASE;
	}

	@RequestMapping("calendarSelect")
	@ResponseBody
	public JsonMessage calendarSelect(BookingsDTO bookInfo, Model model) {
		String id = Integer.toString(bookInfo.getId());
		boolean result = (new BookHelper())
				.filterIsAvaliableBookDate(bookService.searchAvaliableBookDateByRoomID(Integer.parseInt(id)), bookInfo);
		return result ? new JsonMessage(id, null, true, Message.AVAILABLE_DATE)
				: new JsonMessage(id, null, false, Message.UNAVAILABLE_DATE);
	}

	private RoomDTO roomSearch(Paging page, Model model) {
		RoomDTO roomInput;
		if (page == null || page.getCurrentPage() == null) {
			roomInput = roomService.getAllRoomInfoList(page);
		} else {
			if (previousContent != null && !previousContent.equals(page.getContent())) {
				page.setCurrentPage(null);
				page.setStartPage(null);
			}
			previousContent = page.getContent();
			roomInput = roomService.searchedRoomInfoList(page);
		}
		model.addAttribute(PAGING, roomInput.getPaging());
		model.addAttribute(ROOMINFOLIST, roomInput.getRoomInfoList());
		return roomInput;
	}

}
