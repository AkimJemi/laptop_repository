package res.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.member.model.Member;
import res.member.service.MemberService;
public class LoginHandler implements CommandHandler {
	private final static String LOGIN_FORM = "/WEB-INF/res/init/login.jsp";

	private MemberService memberService = new MemberService();
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {
		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("GET")) {
			return processForm(rq, rp);
		} else {
			return null;
		}
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		if(rq.getParameter("id") !=null) {
			return processSubmit(rq, rp);
		}
		return LOGIN_FORM;
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		String id = rq.getParameter("id");
		String password = rq.getParameter("password");
		boolean checkUser = memberService.checkUser(id, password);

		if (!checkUser) {
			rq.setAttribute("error", "login");
			return LOGIN_FORM + "?error=exist";
		}
		Member member = new Member(id, password);
		rq.getSession().setAttribute("loginedUser", member);
		return "main.do";
	}
}