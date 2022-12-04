package com.sinnotech.hotel.dao;

import java.util.List;

import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;

public class UserPageDTO {

	private SetPaging paging;
	private List<UsersDTO> usersDTOList;
	public List<UsersDTO> getUsersDTOList() {
		return usersDTOList;
	}
	public void setUsersDTOList(List<UsersDTO> usersDTOList) {
		this.usersDTOList = usersDTOList;
	}
	public SetPaging getPaging() {
		return paging;
	}
	public void setPaging(SetPaging paging) {
		this.paging = paging;
	}
}
