package com.sinnotech.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.helper.BookHelper;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.RoomService;
import com.sinnotech.hotel.util.JsonMessage;
import com.sinnotech.hotel.util.Message;
import com.sinnotech.hotel.util.PathCollection;
import com.sinnotech.hotel.util.Util;

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
		List<BookingsDTO> theDatesOfTheRoom = bookService.searchAvaliableBookDateByRoomID(Integer.parseInt(id));
		boolean result = (new BookHelper()).filterIsAvaliableBookDate(theDatesOfTheRoom, bookInfo);
		System.out.println(result);
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
