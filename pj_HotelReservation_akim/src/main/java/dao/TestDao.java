package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.TestDto;
import com.sinnotech.hotel.mapper.TestMapper;

@Repository
public class TestDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<TestDto> findAll() {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		return mapper.finaAll();
	}
}
