package res.admin.book.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;
import res.admin.book.model.Book;
import res.admin.book.service.AdminBookService;

public class AdminBookCheckResUpdateHandler implements CommandHandler {
	private final static String BOOK_LIST_FORM = "/WEB-INF/res/admin/adminBook/adminBookList.jsp";
	private AdminBookService bookService = new AdminBookService();
	private AdminBookService adminService = new AdminBookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		ArrayList<Book> book = new ArrayList<Book>();
		int no =0;
		Boolean result = false;
		
		if (rq.getParameter("no") != null)
			no = Integer.parseInt(rq.getParameter("no"));
		else
			return Util.redirectMsgAndBack(rq, "해당 번호를 찾을 수 없습니다.");

		if (rq.getParameter("type") != null) {
			
			result = bookService.UpdateCheck_Res(no, rq.getParameter("type"));
			if (result)
				book = adminService.selectBookList(book);
			else
				return Util.redirectMsgAndBack(rq, "이미 취소 상태입니다");

			rq.setAttribute("book", book);
		} else
			return Util.redirectMsgAndBack(rq, "bookCheckResHandler에서 뭔가 잘못됨");

		return BOOK_LIST_FORM;
	}
}
