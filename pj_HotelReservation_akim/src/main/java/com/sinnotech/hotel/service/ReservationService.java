package com.sinnotech.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dto.ReservationDTO;

@Service
public interface ReservationService {

	List<ReservationDTO> getReservationList();
}
