package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.mapper.ReservationMapper;

@Repository
public class ReservationDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReservationDTO> getReservationList() {
		ReservationMapper mapper = sqlSession.getMapper(ReservationMapper.class);
		return mapper.getReservationList();
	}

}
