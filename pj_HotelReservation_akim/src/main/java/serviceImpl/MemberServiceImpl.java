package com.sinnotech.hotel.serviceImpl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.service.MemberService;
import com.sinnotech.hotel.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<UsersDTO> getMemberList(){
		return memberDAO.getMemberList();
	}
	// 회원 가입
	@Override
	public int insertMember(UsersDTO user){
		return memberDAO.insertMember(user);
	}
	@Override
   public int overlappedEmail(UsersDTO user){
		return memberDAO.overlappedEmail(user);
	}
	@Override
   public int overlappedPhone(UsersDTO user){
		return memberDAO.overlappedPhone(user);
	}
	// 비회원 가입
	@Override
	public int insertNonMember(UsersDTO user){
		return memberDAO.insertNonMember(user);
	}
	@Override
	public UsersDTO getLoginMemberInfo(UsersDTO user) {
		return memberDAO.getLoginMemberInfo(user);
	}
	@Override
	public UsersDTO getLoginNonMemberInfo(UsersDTO user) {
		return memberDAO.getLoginNonMemberInfo(user);
	}
	// 회원정보수정
		@Override
		public void updateMember(UsersDTO user) {
			try {
				memberDAO.updateMember(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
