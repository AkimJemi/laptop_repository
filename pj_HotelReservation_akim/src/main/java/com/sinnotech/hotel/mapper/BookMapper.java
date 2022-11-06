package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomInfoDTO;

@Mapper
public interface BookMapper {

	List<BookingsDTO> getAllBookList(@Param("paging")Paging paging);

	List<BookingsDTO> searchBookList(@Param("paging") Paging paging);

	BookingsDTO getBookInfo(@Param("id") int bookID);

	void updateBookInfo(@Param("book") BookingsDTO book);

	int searchCount(Paging page);

	OptionsDTO getBookingOptions();

	void cancelBookInfo(@Param("bookID") Integer bookID);

	BookingsDTO checkIfBookingCancelled(@Param("bookID") Integer bookID);

	Integer getAllBookingCount();
	
	Integer getSearchedBookingCount(@Param("paging") Paging paging);

	List<BookingsDTO> adminHomeBookInfo(@Param("paging") Paging page);

	Integer adminHomeBookInfoCount(@Param("paging") Paging page);

	List<BookingsDTO> searchBookDateByRoomID(@Param("roomID") Integer roomID);

	List<BookingsDTO> searchAvaliableBookDateByRoomID(Integer roomID);

}
