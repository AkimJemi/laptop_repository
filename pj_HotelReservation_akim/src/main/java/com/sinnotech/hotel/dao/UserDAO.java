package com.sinnotech.hotel.dao;

//import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.mapper.UserMapper;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<Integer> getUserIDByBookContent(String content) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> matchedUserID = mapper.getUserIDByBookContent(content);
		return matchedUserID.size() != 0 ? matchedUserID : null;
	}

	public List<UsersDTO> getUsersInfoList(SetPaging page) {

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.getUsersInfoList(page);

	}

	public List<UsersDTO> getUsersInfoAllList() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.getUsersInfoAllList();

	}

	public Integer getUsersInfoListCount(SetPaging page) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		return userMapper.getUsersInfoListCount(page);

	}

	public boolean deleteUser(Integer id) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(id);

		return false;
	}

	public boolean checkUserById(Integer id) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UsersDTO user = userMapper.checkUserById(id);
		return user.isDeleteFlag() == true ? true : false;
	}

	public int getUsersInfoAllListCount() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.getUsersInfoAllListCount();
	}

	public void updateUserPassword(String newPassword, Integer id) {
		sqlSession.getMapper(UserMapper.class).updateUserPassword(newPassword, id);
	}

	public UsersDTO getUserInfoById(Integer id) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.getUserInfoById(id);
	}

}
