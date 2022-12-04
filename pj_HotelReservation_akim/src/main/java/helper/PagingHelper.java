package com.sinnotech.hotel.helper;

import org.springframework.stereotype.Component;

import com.sinnotech.hotel.dto.Paging;

@Component
public class PagingHelper {

	public Paging fliterPaing(Paging page) {
		if (page.getCurrentPage() < 0)
			page.setCurrentPage(1);

		page.setTotalPage(page.getTotalCount());
		if (page.getCurrentPage() > 3) {
			page.setStartPage(page.getCurrentPage() - 2);
			if (page.getCurrentPage() >= page.getTotalPage() - 2) {
				page.setEndPage((int) page.getTotalPage());
				if (page.getEndPage() == 1)
					page.setStartPage(null);

			} else
				page.setEndPage(page.getCurrentPage() + 2);

		} else {
			page.setStartPage(null);
			if (page.getCurrentPage() >= page.getTotalPage() - 2) {
				page.setEndPage((int) page.getTotalPage());
			} else {
				if (page.getTotalPage() >= 5)
					page.setEndPage(5);
				else
					page.setEndPage((int) page.getTotalPage());
			}
		}
		if (page.getCurrentPage() > page.getTotalPage())
			page.setCurrentPage((int) page.getTotalPage());

		return page;
	}

}
