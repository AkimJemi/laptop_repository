package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.mapper.NoticeMapper;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	public void write(NoticeDTO notice) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.write(notice);
	}

	public List<NoticeDTO> getNoticeList() {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNoticeList();
	}

	public NoticeDTO getNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNotice(noticeId);
	}

	public NoticeDTO updateNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.updateNotice(noticeId);
		return mapper.getNotice(noticeId);
	}

}
