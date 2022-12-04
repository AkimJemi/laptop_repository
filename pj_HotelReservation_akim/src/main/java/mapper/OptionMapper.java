package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.OptionsDTO;

@Mapper
public interface OptionMapper {

	List<OptionsDTO> getBookingOptions();

	List<OptionsDTO> getBookingOptionNameByRoomID(@Param("optionNoList") List<String> optionNoList);

	boolean updateOptions(@Param("options") String options);	
}
