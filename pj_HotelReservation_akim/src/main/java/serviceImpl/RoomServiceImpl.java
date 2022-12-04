package com.sinnotech.hotel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.RoomDAO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;
import com.sinnotech.hotel.helper.PagingHelper;
import com.sinnotech.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDAO roomDao;

	@Autowired
	private PagingHelper pagingHelper;

	@Override
	public RoomDTO getAllRoomInfoList(Paging page) {
		RoomDTO roomInfo = new RoomDTO();
		roomInfo.getPaging().setTotalPage(roomDao.searchAllRoomInfoCount());
		double total = roomInfo.getPaging().getTotalPage();
		roomInfo.setRoomInfoList(roomDao.searchAllRoomInfoList());
		roomInfo.getPaging().setStartPage(null);
		roomInfo.getPaging().setCurrentPage(null);
		roomInfo.getPaging().setEndPage(total > 5 ? 5 : (int) total);
		return roomInfo;
	}

	@Override
	public RoomDTO searchedRoomInfoList(Paging page) {
		page = updatePagingWithTitleAndContents(page);
		page.setTotalCount(roomDao.searchedRoomCount(page));
		return roomDao.searchedRoomInfoList(pagingHelper.fliterPaing(page));
	}

	@Override
	public RoomInfoDTO searchRoomInfoDetailByRoomID(Integer roomID) {
		return roomDao.searchRoomInfoDetailByRoomID(roomID);
	}

	public Paging updatePagingWithTitleAndContents(Paging page) {
		switch (page.getTitle()) {
		case Paging.NO:
			break;
		case Paging.ROOM:
			page.setContentsIDList(roomDao.getRoomIDByBookContent(page.getContent()));
			break;
		}
		return page;
	}

}
