package com.sinnotech.hotel.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {
	private Paging paging;
	private List<RoomInfoDTO> roomInfoList;

	public RoomDTO(List<RoomInfoDTO> roomInfoList, Paging page) {
		this.roomInfoList = roomInfoList;
		this.paging = page;
	}

	public RoomDTO() {
		paging = new Paging();
		roomInfoList = new ArrayList<>();
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging page) {
		this.paging = page;
	}

	public List<RoomInfoDTO> getRoomInfoList() {
		return roomInfoList;
	}

	public void setRoomInfoList(List<RoomInfoDTO> roomInfoList) {
		this.roomInfoList = roomInfoList;
	}

}
