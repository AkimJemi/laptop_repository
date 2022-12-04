package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinnotech.hotel.dao.TestDao;
import com.sinnotech.hotel.dto.TestDto;
import com.sinnotech.hotel.mapper.TestMapper;
import com.sinnotech.hotel.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;

	@Override
	public List<TestDto> finaAll() {
		// TODO Auto-generated method stub
		return testDao.findAll();
	}

}
