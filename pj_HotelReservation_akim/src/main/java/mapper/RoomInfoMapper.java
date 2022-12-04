package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.Paging;

@Mapper
public interface RoomInfoMapper {

	List<AdminRoomInfoDTO> getRoomInfoList();
	AdminRoomInfoDTO getRoomInfoDetail(int room_id);
	int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO);
}
