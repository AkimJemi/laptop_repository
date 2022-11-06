package com.sinnotech.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.RoomInfoService;
import com.sinnotech.hotel.util.PathCollection;

@Controller
@RequestMapping("client/book")
public class ClientBookController extends BaseController implements PathCollection {

	private final String CLIENT_BOOK = CLIENT_BASE_PATH + BOOK + "/" + BOOK;
	private final String CLIENT_BOOK_FORM = CLIENT_BASE_PATH + BOOK + "/" + FORM;
	private final String CLIENT_BOOK_CALENDAR = CLIENT_BASE_PATH + BOOK + "/" + "bookingCalendar";

	@Autowired
	private BookService bookService;

	@Autowired
	private RoomInfoService roomService;

	@RequestMapping("")
	public String BookMainPage(Model model) {
		model.addAttribute("roomInfoList", roomService.getRoomInfoList());
		return CLIENT_BOOK;
	}

	@RequestMapping("/{roomID}")
	public String Booking(Model model, @PathVariable("roomID") Integer roomID) {
		model.addAttribute("roomInfo", roomService.getRoomInfoDetail(roomID));
		return CLIENT_BOOK_FORM;
	}

	@RequestMapping("calendar")
	public String Calendar(AdminRoomInfoDTO roomInfo, Model model) {
		model.addAttribute("bookingDates", bookService.searchAvaliableBookDateByRoomID(roomInfo.getId()));
		return CLIENT_BOOK_CALENDAR;
	}

	@RequestMapping("calendarSelect")
	@ResponseBody
	public String CalendarSelect(BookingsDTO bookDto, Model model) {

		System.out.println("ClientBookController.CalendarSelect()");
		System.out.println(bookDto.getStartDate());
		System.out.println(bookDto.getEndDate());
		System.out.println(bookDto.getId());
		return null;
	}
}
