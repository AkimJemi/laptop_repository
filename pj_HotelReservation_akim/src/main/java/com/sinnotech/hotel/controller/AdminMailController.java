package com.sinnotech.hotel.controller;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminMailController {
	@Autowired
	JavaMailSender mailSender;// 위에서 만든 이메일 송신용 config 클래스 선언

	@ResponseBody
	@RequestMapping(value = "member/dd", produces = "text/html; charset=UTF-8")
	public String sendAuth(@RequestBody(required = false) String email) {
		// ﻿(required = false) 매개변수의 null의 여부를 지정 -> false == null일 수도 있다.
		try {
			
			email = "wowp100@naver.com";
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
			// 헬퍼를 이용해서 email 연결 정보를 입력하는게 더 편리함
			// 데이터의 양이 많다면 두번쨰 영역을 true를 하면된다 == multipart
			// 마지막은 인코딩 형식 == utf-8
			String newPassword = UUID.randomUUID().toString().substring(0,5);
			msgHelper.setSubject(""); // 이메일의 제목
			msgHelper.setText("임시 이메일 번호는 "+ newPassword); // 이메일의 내용
			msgHelper.setTo(email); // jsp에서 받은 수신자 이메일 번호
			msgHelper.setFrom("wowp100@naver.com");
			mailSender.send(message);// 메일을 송부
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "송신 완료"; // 이상 없을 시 문자열 jsp에 리턴
	}
}