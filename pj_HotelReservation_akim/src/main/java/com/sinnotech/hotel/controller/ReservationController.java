package com.sinnotech.hotel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinnotech.hotel.dao.ReservationDAO;
import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.dto.TestDto;
import com.sinnotech.hotel.service.ReservationService;

@Controller
public class ReservationController extends BaseController {
	private final String ReservationLIST_FORM = CLIENT_BASE_PATH+"Reservation/ReservationList";
	
	@Autowired
	ReservationService ReservationService;
	
	@RequestMapping(value = "reservation", method = RequestMethod.GET)
	public ModelAndView index() {
		
		
		ModelAndView model = new ModelAndView(ReservationLIST_FORM);
		return model;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r_checkin = request.getParameter("r_checkin");
		String r_checkout = request.getParameter("r_checkout");
		int r_adults = Integer.parseInt(request.getParameter("r_adults"));
		int r_kids = Integer.parseInt(request.getParameter("r_kids"));	

		String msg = "";
		ReservationDAO rDAO = new ReservationDAO();
		ArrayList<RoomDTO> room_type = rDAO.selectRoomByPeople(r_adults+r_kids);
		ArrayList<RoomDTO> totalroom = rDAO.selectRoomByDate(room_type, r_checkin, r_checkout);
		
		if(totalroom.size()==0){
			msg = "예약 가능하신 방이 없습니다.다시 선택해주세요";
		}
		
		String  str = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		long diffday = 0;
		try {
			Date checkin = sdf.parse(r_checkin);
			Date checkout = sdf.parse(r_checkout);
			
			diffday = (checkout .getTime() - checkin.getTime()) / (24*60*60*1000);
		
		} catch (ParseException e) {
			System.err.println("ReservationRoomServlet - doGet() err : " + e.getMessage());
		}
		
		request.setAttribute("diffday", diffday);
		request.setAttribute("r_checkin", r_checkin);
		request.setAttribute("r_checkout", r_checkout);
		request.setAttribute("r_adults", r_adults);
		request.setAttribute("r_kids", r_kids);
		request.setAttribute("totalroom", totalroom);
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("reservation2.jsp");
		rd.forward(request, response);
		
	}
	
}