package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.NoticeDTO;

public interface NoticeService {

	void write(NoticeDTO notice);

	List<NoticeDTO> getNoticeList();

	NoticeDTO getNotice(Integer noticeId);

	NoticeDTO updateNotice(Integer noticeId);

}
