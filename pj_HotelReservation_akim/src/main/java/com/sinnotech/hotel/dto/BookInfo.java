package com.sinnotech.hotel.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookInfo {
	private List<BookingsDTO> bookDTOList;
	private Paging paging;
	private List<OptionsDTO> options;
	private List<OptionListInfo> optionInfo;

	public BookInfo(List<BookingsDTO> bookDTOList, Paging paging) {
		this.bookDTOList = bookDTOList;
		this.paging = paging;
	}
	
	public BookInfo() {
		bookDTOList = new ArrayList<BookingsDTO>();
		paging = new Paging();
		options = new ArrayList<OptionsDTO>();
		optionInfo = new ArrayList<OptionListInfo>();
	}

	public BookInfo(List<BookingsDTO> adminHomeBookInfo) {
	}

	public List<BookingsDTO> getBookDTOList() {
		return bookDTOList;
	}

	public void setBookDTOList(List<BookingsDTO> bookDTOList) {
		this.bookDTOList = bookDTOList;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public List<OptionsDTO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsDTO> options) {
		this.options = options;
	}

	public List<OptionListInfo> getOptionInfo() {
		return optionInfo;
	}

	public void setOptionInfo(List<OptionListInfo> optionInfo) {
		this.optionInfo = optionInfo;
	}


}
