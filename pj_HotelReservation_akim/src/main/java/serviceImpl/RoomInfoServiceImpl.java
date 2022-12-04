package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.RoomInfoDAO;
import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;
import com.sinnotech.hotel.service.RoomInfoService;

@Service
public class RoomInfoServiceImpl implements RoomInfoService{

	@Autowired
	private RoomInfoDAO roomInfoDAO;
	
	@Override
	public List<AdminRoomInfoDTO> getRoomInfoList() {
		return roomInfoDAO.getRoomInfoList();
	}
	
	@Override
	public AdminRoomInfoDTO getRoomInfoDetail(int room_id) {
		return roomInfoDAO.getRoomInfoDetail(room_id);
	}

	@Override
	public int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		return roomInfoDAO.getRoomInfoInsert(adminRoomInfoDTO);
	}

	
	
	
}
