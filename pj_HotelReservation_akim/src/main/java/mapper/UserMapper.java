package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;

@Mapper
public interface UserMapper {

	List<Integer> getUserIDByBookContent(@Param("content") String content);

	List<UsersDTO> getUsersInfoList(@Param("page") SetPaging page);

	Integer getUsersInfoListCount(@Param("page") SetPaging page);

	List<UsersDTO> getUsersInfoAllList();

	void deleteUser(Integer id);

	UsersDTO checkUserById(Integer id);

	int getUsersInfoAllListCount();

	void updateUserPassword(@Param("newPassword") String newPassword, @Param("id") Integer id);

	UsersDTO getUserInfoById(Integer id);

	UsersDTO checkUserDeleteFlagById(Integer id);

}
