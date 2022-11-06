package com.sinnotech.hotel.dto;

import java.util.List;

import com.sinnotech.hotel.util.Util;

import lombok.Data;

public class Paging {
	public final static String NO = "no";
	public final static String ROOM = "room";
	public final static String USER = "user";
	public final static String DATE = "date";

	/* 페이징 URL용 */
	public final static String TITLE = "title", CONTENT = "content", CURRENTPAGE = "currentPage",
			STARTDATE = "startDate", ENDDATE = "endDate", DELETEFLAG = "deleteFlag";
	public final String GU = "&", EQUAL = "=";

	/* 검색 */
	private String title;
	private String content;
	private Integer contentForId;
	private String bookingCode;
	private String startDate;
	private String endDate;
	private Boolean deleteFlag;

	private List<Integer> contentsIDList;

	/* 페이징 */
	private Integer startPage;
	private Integer currentPage;
	private Integer endPage;
	private Integer totalPage;
	private Integer totalCount;

	public Paging() {
		deleteFlag = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getContentForId() {
		return contentForId;
	}

	public void setContentForId(Integer contentForId) {
		this.contentForId = contentForId;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<Integer> getContentsIDList() {
		return contentsIDList;
	}

	public void setContentsIDList(List<Integer> contentsIDList) {
		this.contentsIDList = contentsIDList;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getContent() {
		return content;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setContent(String content) {
		this.content = content;
		if (Util.CheckNumber(content)) {
			this.contentForId = Integer.parseInt(content);
		}
	}

	public void setStartPage(Integer startPage) {
		if (startPage != null && startPage != 0) {
			this.startPage = startPage;
		} else {
			this.startPage = 1;
		}
	}

	public void setTotalPage(Integer total) {
		int page = (int) Math.ceil((double) total / 20);
		this.totalPage = page != 0 ? page : 1;
	}

	public void setCurrentPage(Integer currentPage) {
		if (currentPage != null && currentPage != 0)
			this.currentPage = currentPage;
		else
			this.currentPage = 1;
	}

	public String searchPreviousPaging(Paging page) {
		StringBuilder url = new StringBuilder();
		String[] key = { TITLE, CONTENT, CURRENTPAGE, STARTDATE, ENDDATE, DELETEFLAG };
		Object[] value = { page.getTitle(), page.getContent(), page.getCurrentPage(), page.getStartDate(),
				page.getEndDate(), page.getDeleteFlag() };
		url.append("?");
		for (int i = 0; i < key.length; i++)
			if (value[i] != null)
				url.append(GU + key[i] + EQUAL + value[i]);
		return url.toString();

	}
}
