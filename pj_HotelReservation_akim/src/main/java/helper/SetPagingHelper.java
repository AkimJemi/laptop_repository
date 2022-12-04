package com.sinnotech.hotel.helper;

import org.springframework.stereotype.Component;

import com.sinnotech.hotel.dto.SetPaging;

@Component
public class SetPagingHelper {

	public SetPaging userPaging(SetPaging page) {
		if (page.getCurrentPage() < 0)
			page.setCurrentPage(1);

		if (page.getCurrentPage() > 3) {
			page.setStartPage(page.getCurrentPage() - 2);
			if (page.getCurrentPage() >= page.getTotal() - 2) {
				page.setEndPage((int) page.getTotal());
			} else {
				page.setEndPage(page.getCurrentPage() + 2);
			}
		} else {
			page.setStartPage(1);
			if (page.getCurrentPage() >= page.getTotal() - 2) {
				page.setEndPage((int) page.getTotal());
			} else {
				if (page.getTotal() >= 5)
					page.setEndPage(5);
				else
					page.setEndPage((int) page.getTotal());
			}
		}
		if (page.getCurrentPage() > page.getTotal())
			page.setCurrentPage((int) page.getTotal());

		return page;
	}

}
