package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;
import com.sinnotech.hotel.mapper.RoomInfoMapper;
import com.sinnotech.hotel.mapper.RoomMapper;

@Repository
public class RoomDAO {
	@Autowired
	private SqlSession sqlSession;

	/* 모든 방정보 리스트 취득 */
	public List<RoomInfoDTO> searchAllRoomInfoList() {
		return sqlSession.getMapper(RoomMapper.class).searchAllRoomInfoList();
	}

	/* 모든 방정보 갯수 취득 */
	public Integer searchAllRoomInfoCount() {
		return sqlSession.getMapper(RoomMapper.class).searchAllRoomInfoCount();
	}

	/* 검색된 방정보 리스트 취득 */
	public RoomDTO searchedRoomInfoList(Paging page) {
		List<RoomInfoDTO> roomInfoList = sqlSession.getMapper(RoomMapper.class).searchedRoomInfoList(page);
		return new RoomDTO(roomInfoList, page);
	}

	/* 검색된 방정보 갯수 취득 */
	public Integer searchedRoomCount(Paging page) {
		return sqlSession.getMapper(RoomMapper.class).searchedRoomCount(page);
	}

	public List<Integer> getRoomIDByBookContent(String content) {
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		List<Integer> roomInfo = mapper.getRoomIDByBookContent(content);
		return roomInfo.size() != 0 ? roomInfo : null;
	}

	public RoomInfoDTO searchRoomInfoDetailByRoomID(Integer roomID) {
		return sqlSession.getMapper(RoomMapper.class).searchRoomInfoDetailByRoomID(roomID);
	}

}
