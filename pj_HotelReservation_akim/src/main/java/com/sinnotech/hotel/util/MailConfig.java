package com.sinnotech.hotel.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//이메일을 이용한 메일 인증 연습
@Configuration
public class MailConfig {

	@Bean // 스프링 컨테이너에 올리기 위한 언옵테이션
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		// 접속 정보 설정
		jms.setHost("smtp.naver.com");// 어느 이메일(메일서버)을 이용하여 메일을 보낼 것이냐?
		// 회사처럼 사설 메일 서버가 없기에 구글 메일을 이용
		jms.setPort(465);// 구글메일에서 사용하는 포트 명은 지정되어 있다.
		jms.setUsername("wowp100@naver.com");// 인증번호를 보낼 이메일 번호
		jms.setPassword("tnwjd941108");// 위 이메일 번호의 비밀번호

		// 연결을 위한 접속 관리 정보
		Properties p = new Properties();//
		p.put("mail.smtp.host", "smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.transport.protocol", "smtp");
		jms.setJavaMailProperties(p);// 이메일의 Property 속성정보를 넣기 위함
		return jms;// 이메일 전송을 위한 속성 값들이 들어있는 객체를 리턴함
	}
}