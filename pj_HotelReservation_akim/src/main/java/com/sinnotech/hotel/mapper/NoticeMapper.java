package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {

	void write(@Param("notice") NoticeDTO notice);

	List<NoticeDTO> getNoticeList();

	NoticeDTO getNotice(@Param("id") Integer noticeId);

	NoticeDTO updateNotice(@Param("id") Integer noticeId);

}
