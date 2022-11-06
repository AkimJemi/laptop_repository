package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;

public interface BookService {

	BookInfo searchAllBookList(Paging page);

	BookInfo searchBookList(Paging page);

	BookingsDTO searchBookInfoByBookID(Integer bookID);

	BookingsDTO updateBookInfo(BookingsDTO bookingsDTO);

	boolean cancelBookInfoByBookID(Integer bookID);

	BookInfo adminHomeBookInfo(Paging page);

	List<BookingsDTO> searchBookDateByRoomID(Integer roomID);

	List<BookingsDTO> searchAvaliableBookDateByRoomID(Integer roomID);

}
