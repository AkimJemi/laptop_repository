package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.mapper.OptionMapper;

@Repository
public class OptionsDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<OptionsDTO> getBookingOptions() {
		OptionMapper mapper = sqlSession.getMapper(OptionMapper.class);
		return mapper.getBookingOptions();
	}

public List<OptionsDTO> getBookingOptionNameByRoomID(List<String> optionNoList) {
		OptionMapper mapper = sqlSession.getMapper(OptionMapper.class);
		return mapper.getBookingOptionNameByRoomID(optionNoList);
	}

public boolean updateOptions(int id, String options) {
	OptionMapper mapper = sqlSession.getMapper(OptionMapper.class);
	return mapper.updateOptions(options);
}

}
