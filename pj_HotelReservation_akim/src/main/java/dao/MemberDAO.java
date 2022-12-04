package com.sinnotech.hotel.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.mapper.MemberMapper;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;

	public List<UsersDTO> getMemberList(){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.getMemberList();
	}; 
	
// 회원 가입
	public int insertMember(UsersDTO usersDTO) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insertMember(usersDTO);
	}
	public int overlappedEmail(UsersDTO usersDTO) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.overlappedEmail(usersDTO);
	};
	public int overlappedPhone(UsersDTO usersDTO) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.overlappedPhone(usersDTO);
	};
// 비회원 가입
	public int insertNonMember(UsersDTO usersDTO) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insertNonMember(usersDTO);
	}
	public UsersDTO getLoginMemberInfo(UsersDTO user) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.getLoginMemberInfo(user);
	}
	public UsersDTO getLoginNonMemberInfo(UsersDTO user) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.getLoginNonMemberInfo(user);
	}
	public void updateMember(UsersDTO user) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return;
	}
}