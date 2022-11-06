package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sinnotech.hotel.dto.TestDto;

@Mapper
public interface TestMapper {

	List<TestDto> finaAll();
}

