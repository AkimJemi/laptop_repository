package com.sinnotech.hotel.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sinnotech.hotel.dto.UsersDTO;

@Mapper
public interface MemberMapper {
	List<UsersDTO> getMemberList();
	int insertMember(UsersDTO user);
	int overlappedEmail(UsersDTO user);
	int overlappedPhone(UsersDTO user);
	int insertNonMember(UsersDTO user);
	public UsersDTO getLoginMemberInfo(UsersDTO user);
	public UsersDTO getLoginNonMemberInfo(UsersDTO user);
	public void updateMember(UsersDTO user);
}
