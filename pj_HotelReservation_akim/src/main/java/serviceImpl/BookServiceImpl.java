package com.sinnotech.hotel.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.BookDAO;
import com.sinnotech.hotel.dao.RoomDAO;
import com.sinnotech.hotel.dao.UserDAO;
import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.helper.PagingHelper;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.OptionsService;
import com.sinnotech.hotel.util.Util;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoomDAO roomDao;
	@Autowired
	private OptionsService optionsService;
	@Autowired
	private PagingHelper pagingHelper;

	@Override
	public BookInfo searchAllBookList(Paging page) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.getPaging().setTotalPage(bookDao.getAllBookingCount());
		double total = bookInfo.getPaging().getTotalPage();
		bookInfo.setBookDTOList(bookDao.getAllBookList(page));
		bookInfo.getPaging().setStartPage(1);
		bookInfo.getPaging().setCurrentPage(1);
		bookInfo.getPaging().setEndPage(total > 5 ? 5 : (int) total);
		bookInfo.setOptions(optionsService.getBookingOptions());
		return bookInfo;
	}

	@Override
	public BookInfo searchBookList(Paging page) {
		page = updatePagingWithTitleAndContents(page);
		if (!page.getStartDate().isEmpty())
			page.setStartDate(Util.DateForDB(page.getStartDate()));
		if (!page.getEndDate().isEmpty())
			page.setEndDate(Util.DateForDB(page.getEndDate()));
		page.setTotalCount(bookDao.getSearchedBookingCount(page));
		return bookDao.searchBookList(pagingHelper.fliterPaing(page));
	}

	@Override
	public BookingsDTO searchBookInfoByBookID(Integer id) {
		return bookDao.getBookInfo(id);
	}

	@Override
	public BookingsDTO updateBookInfo(BookingsDTO bookingsDTO) {
		return bookDao.updateBookInfo(bookingsDTO) != null ? searchBookInfoByBookID(bookingsDTO.getId()) : null;
	}

	@Override
	public boolean cancelBookInfoByBookID(Integer room) {
		return bookDao.cancelBookInfo(room);
	}

	@Override
	public BookInfo adminHomeBookInfo(Paging page) {
		if (page.getTitle() != null)
			page = updatePagingWithTitleAndContents(page);
		page.setTotalCount(bookDao.adminHomeBookInfoCount(page));
		page.setStartDate((new SimpleDateFormat("yyyyMMdd")).format(Calendar.getInstance().getTime()));
		return new BookInfo(bookDao.adminHomeBookInfo(pagingHelper.fliterPaing(page)), page);
	}

	@Override
	public List<BookingsDTO> searchBookDateByRoomID(Integer roomID) {
		return bookDao.searchBookDateByRoomID(roomID);
	}

	public Paging updatePagingWithTitleAndContents(Paging page) {
		switch (page.getTitle()) {
		case Paging.CONTENT:
		case Paging.NO:
			break;
		case Paging.ROOM:
			page.setContentsIDList(roomDao.getRoomIDByBookContent(page.getContent()));
			break;
		case Paging.USER:
			page.setContentsIDList(userDao.getUserIDByBookContent(page.getContent()));
			break;
		}
		return page;
	}

	@Override
	public List<BookingsDTO> searchAvaliableBookDateByRoomID(Integer roomID) {
		return bookDao.searchAvaliableBookDateByRoomID(roomID);
	}

}
