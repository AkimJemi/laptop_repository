package main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class MainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		System.out.println("test");
		
		System.out.println("dd");
		return null;
	}

}
