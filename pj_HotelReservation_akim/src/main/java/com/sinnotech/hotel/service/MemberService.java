package com.sinnotech.hotel.service;

import java.util.List;
import com.sinnotech.hotel.dto.UsersDTO;

public interface MemberService {

	public List<UsersDTO> getMemberList();
	public UsersDTO getLoginMemberInfo(UsersDTO user);
	public UsersDTO getLoginNonMemberInfo(UsersDTO user);
	// 회원 가입	
	public int insertMember(UsersDTO user) throws Exception;
	// 비회원 가입
	public int insertNonMember(UsersDTO user) throws Exception;
	public int overlappedEmail(UsersDTO user) throws Exception;
	public int overlappedPhone(UsersDTO user) throws Exception;
	//회원정보 수정
	public void updateMember(UsersDTO user);
}
