package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.mapper.RoomInfoMapper;

@Repository
public class RoomInfoDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<AdminRoomInfoDTO> getRoomInfoList(){
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoList();
	}
	
	public AdminRoomInfoDTO getRoomInfoDetail(int room_id){
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoDetail(room_id);
	}
	
	public int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoInsert(adminRoomInfoDTO);
	}

}
