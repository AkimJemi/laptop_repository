package com.sinnotech.hotel.helper;

import java.util.ArrayList;
import java.util.List;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.OptionListInfo;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.util.Constants;

public class OptionHelper {

	public BookInfo selectedOptionHelper(List<OptionsDTO> options, List<OptionsDTO> selectedOptions) {
		if (selectedOptions != null) {
//			options.stream().iterator().forEachRemaining(t -> t.setSelected(
//					selectedOption.stream().anyMatch(s -> s.getBookingCode().equals(t.getBookingCode())) ? "selected"
//							: ""));

			BookInfo filteredOption = new BookInfo();
			List<OptionListInfo> optionList = new ArrayList<OptionListInfo>();
			for (int i = 0; i < selectedOptions.size(); i++) {
				String selectedOption = selectedOptions.get(i).getBookingCode();
				List<OptionsDTO> optionDTOList = new ArrayList<>();
				for (OptionsDTO optionInfo : options) {
					OptionsDTO newOption = new OptionsDTO();
					newOption.setBookingCode(optionInfo.getBookingCode());
					newOption.setInfo(optionInfo.getInfo());
					if (optionInfo.getBookingCode().equals(selectedOption))
						newOption.setSelected(Constants.SELECTED);
					else
						newOption.setSelected(Constants.UNSELECTED);
					
					optionDTOList.add(newOption);
				}
				optionList.add(new OptionListInfo(optionDTOList));
			}
			filteredOption.setOptionInfo(optionList);
			return filteredOption;
		}
		return null;
	}
}
