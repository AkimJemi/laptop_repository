<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script src="${contextpath}/resources/js/member/login.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/commonMember.css" />
</head>
<div class="tab_menu">
  <ul class="list">
    <li class="is_on">
      <a href="/login" class="btn">회원 로그인 </a>
    </li>
    <li>
      <a href="/nonUserLogin" class="btn">비회원 로그인 </a>
	<div>
	<h1>회원 로그인</h1>
	<form:form action="/login" method="post" modelAttribute="loginUser" autocomplete="off">
		<div class="form-group">
			<label for="email">이메일(아이디)</label>
			<form:input path="email" type="text" class="form-control" id="email"
				placeholder="Enter email" />
				 <form:errors path="email"/>
		</div>
		<div class="form-group">
			<label for="password">비밀번호 </label>
			<form:input path="password" type="password" class="form-control" id="password"
				placeholder="비밀번호를 입력해주세요 " />
				 <form:errors path="password"/>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<li>
		  <a href="/signup" class="btn">회원가입 </a>
		</li>
	</form:form>
	</div>
    </li>
  </ul>
<p>${loginUserInfo}</p>
</div>