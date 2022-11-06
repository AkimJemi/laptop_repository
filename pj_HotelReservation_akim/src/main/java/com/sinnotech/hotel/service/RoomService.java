package com.sinnotech.hotel.service;

import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;

public interface RoomService {

	RoomDTO searchedRoomInfoList(Paging page);

	RoomInfoDTO searchRoomInfoDetailByRoomID(Integer roomID);

	RoomDTO getAllRoomInfoList(Paging page);
}
