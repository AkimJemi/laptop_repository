package com.sinnotech.hotel.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.util.Util;

public class BookHelper {

	public boolean filterIsAvaliableBookDate(List<BookingsDTO> theDatesOfTheRoom, BookingsDTO bookInfo) {
//		List<BookingsDTO> avaliableDates = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String Sstr = Util.DateForView(bookInfo.getStartDate());
			String Send = Util.DateForView(bookInfo.getEndDate());
			Date Dstr = sdf.parse(Util.DateForView(bookInfo.getStartDate()));
			Date Dend = sdf.parse(Util.DateForView(bookInfo.getEndDate()));
			for (BookingsDTO date : theDatesOfTheRoom) {
				// 선택한 날이 예약이 있는 경우
				Date strD = sdf.parse(date.getStartDate());
				Date endD = sdf.parse(date.getEndDate());
				String strS = sdf.format(strD);
				String endS = sdf.format(endD);

				if (Sstr.equals(strS) && Send.equals(endS)) {
					return false;
				} else if (strD.after(Dstr) && endD.before(Dend)) {
					return false;
				}

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			final Date str = sdf.parse(bookInfo.getStartDate());
//			final Date end = sdf.parse(bookInfo.getEndDate());
//			avaliableDates = theDatesOfTheRoom.stream().filter(t -> {
//				try {
//					return sdf.parse(t.getStartDate()).before(str);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				return false;
//			}).filter(y -> {
//				try {
//					return sdf.parse(y.getEndDate()).after(end);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				return false;
//			}).collect(Collectors.toList());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return !avaliableDates.isEmpty();
	}

}
