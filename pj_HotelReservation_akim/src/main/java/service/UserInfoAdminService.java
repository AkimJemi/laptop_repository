package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dao.UserPageDTO;
import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;

public interface UserInfoAdminService {

	List<UsersDTO> getUsersInfoAllList();

	boolean deleteUser(Integer id);

	UserPageDTO getUsersInfoList(SetPaging page);

	int getUsersInfoAllListCount();

	boolean updateUserPassword(String newPassword, Integer id);

}
