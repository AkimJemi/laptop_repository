package com.sinnotech.hotel.util;

import javax.servlet.http.HttpServletRequest;

import com.sinnotech.hotel.dto.Paging;

public class Util {

	public static String GET_RETURN_KIND;

	public static void setGET_RETURN_KIND(HttpServletRequest rq, String getReturnKind, Paging page) {
		rq.getSession().setAttribute("getReturnKind", getReturnKind + page.searchPreviousPaging(page));
		GET_RETURN_KIND = getReturnKind;
	}

	public static boolean CheckNumber(String str) {
		char check;
		if (str.equals("")) {
			// 문자열이 공백인지 확인
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			check = str.charAt(i);
			if (check < 48 || check > 58)
				return false;
		}
		return true;
	}

	public static String DateForView(String startDate) {
		String yyyy = startDate.substring(0, 4);
		String mm = startDate.substring(4, 6);
		String dd = startDate.substring(6, 8);
		StringBuilder str = new StringBuilder();
		return str.append(yyyy + "-" + mm + "-" + dd).toString();
	}

	public static String DateForDB(String startDate) {
		String[] date = startDate.split("-");
		return date[0] + date[1] + date[2];
	}

}
