package com.sinnotech.hotel.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.NoticeDAO;
import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.service.NoticeService;
import com.sinnotech.hotel.util.Util;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDao;	

	@Override
	public void write(NoticeDTO notice) {
		notice.setEndDate(Util.DateForDB(notice.getEndDate()));
		notice.setStartDate(Util.DateForDB(LocalDate.now().toString()));
		noticeDao.write(notice);
	}

	@Override
	public List<NoticeDTO> getNoticeList() {
		return noticeDao.getNoticeList();
	}

	@Override
	public NoticeDTO getNotice(Integer noticeId) {
		return noticeDao.getNotice(noticeId);
	}

	@Override
	public NoticeDTO updateNotice(Integer noticeId) {
		return noticeDao.updateNotice(noticeId);
	}


}
