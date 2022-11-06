package com.sinnotech.hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class OptionListInfo {
	private List<OptionsDTO> optionListInfo;
	
	public List<OptionsDTO> getOptionListInfo() {
		return optionListInfo;
	}

	public void setOptionListInfo(List<OptionsDTO> optionListInfo) {
		this.optionListInfo = optionListInfo;
	}

	public OptionListInfo(List<OptionsDTO> optionDTOList) {
		this.optionListInfo = optionDTOList;
	}

}
