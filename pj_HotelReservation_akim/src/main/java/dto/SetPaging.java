package com.sinnotech.hotel.dto;

public class SetPaging {
	
	private String searchType;


	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	private String searchKeyword;
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
	private Integer currentPage;
	private Integer endPage;
	private double total;
	private Integer startPage;

	public SetPaging() {
	}

	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		if(startPage != null && startPage != 0) {
			this.startPage = startPage;
		}else {
			this.startPage = 1;
		}
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if(currentPage != null && currentPage != 0) {
			this.currentPage = currentPage;
		}else {
			this.currentPage = 1;
		}
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = Math.ceil(total/20);
	}

}
