package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.ReservationDAO;
import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDAO ReservationDAO;
	
	@Override
	public List<ReservationDTO> getReservationList() {

		return ReservationDAO.getReservationList();
	}


}
