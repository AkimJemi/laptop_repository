package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomInfoDTO;

@Mapper
public interface RoomMapper {

	/* 모든 방정보 리스트 취득 */
	List<RoomInfoDTO> searchAllRoomInfoList();

	/* 모든 방정보 갯수 취득 */
	Integer searchAllRoomInfoCount();

	/* 검색된 방정보 리스트 취득 */
	List<RoomInfoDTO> searchedRoomInfoList(@Param("paging") Paging page);

	/* 검색된 방정보 갯수 취득 */
	Integer searchedRoomCount(@Param("paging") Paging page);
	
	List<Integer> getRoomIDByBookContent(@Param("content") String content);

	RoomInfoDTO searchRoomInfoDetailByRoomID(@Param("roomID") Integer roomID);
}
