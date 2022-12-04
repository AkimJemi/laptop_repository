package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.OptionsDTO;


public interface OptionsService {

	List<OptionsDTO> getBookingOptions();

	List<OptionsDTO> getBookingOptionNameByRoomID(String options);
	

}
