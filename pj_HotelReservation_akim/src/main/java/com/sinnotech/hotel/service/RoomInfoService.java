package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;

public interface RoomInfoService {
	
	List<AdminRoomInfoDTO>  getRoomInfoList();
	AdminRoomInfoDTO  getRoomInfoDetail(int room_id);
	int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO);
	

}
