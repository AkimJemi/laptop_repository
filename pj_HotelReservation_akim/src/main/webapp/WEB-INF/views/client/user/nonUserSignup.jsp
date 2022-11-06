<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script src="${contextpath}/resources/js/member/memberInput.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/nonUserLogin.css" />
</head>
<body>
	<ul>
	<li>
      <a href="/signup" class="btn">회원으로 가입 </a>
      </li>
      <li>
      <a href="/nonUserSignup" class="btn">비회원으로 가입 </a>
      </li>
      </ul>
	<form:form action="/user/insertNonMember" method="post" modelAttribute="nonUserInfo" autocomplete="off">
	<div>
	<h1>비회원으로 가입 </h1>
		<form:label path="email">이메일(최소 8자 최대 30자)</form:label>
		<form:input path="email" type="email" id="email" name="email" required="required" maxlength="30" oninput="emailCheck();"/>
		<span id="olmessage"></span>
		<p id="email-warning-message"></p>
		<p id="email-overlapse-message"></p>
	</div>
	<div>
		<form:label path="name">이름(최소2자 최대20자)</form:label>
		<form:input type="text" path="name" id="name" name="name" required="required" maxlength="20"/>
		<p id="name-warning-message"></p>
	</div>
	<div>
		<form:label path="phone">전화번호('-'없이 입력 최대11자)</form:label>
		<form:input type="text" path="phone" id="phone" name="phone" required="required" maxlength="11" oninput="phoneCheck();"/>
		<span id="phmessage"></span>
		<p id="phone-warning-message"></p>
		<p id="phone-overlapse-message"></p>
	</div>
	<div class="form-group">
								<form
									action="/insertNonMember"
									method="post"
									class="form-horizontal"
								>
									<div class="form-group">
										<div>
											<input
												type="submit"
												value="회원가입"
												id="submit"
											/>
										</div>
									</div>
									<div class="">
										<button id="btnCancel" type="button">취소</button>
									</div>
								</form>
								</div>
	</form:form>
</body>