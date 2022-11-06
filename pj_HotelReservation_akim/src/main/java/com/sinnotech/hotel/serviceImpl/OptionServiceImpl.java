package com.sinnotech.hotel.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.OptionsDAO;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.service.OptionsService;

@Service
public class OptionServiceImpl implements OptionsService {

	@Autowired
	private OptionsDAO optionDao;

	@Override
	public List<OptionsDTO> getBookingOptions() {
		return optionDao.getBookingOptions();
	}

	@Override
	public List<OptionsDTO> getBookingOptionNameByRoomID(String options) {
		List<String> optionNoList = Arrays.asList(options.split(","));
		return optionNoList.size() != 0 ? optionDao.getBookingOptionNameByRoomID(optionNoList) : null;
	}

	public boolean updateOptions(int id, String options) {
		return optionDao.updateOptions(id, options);

	}

}
