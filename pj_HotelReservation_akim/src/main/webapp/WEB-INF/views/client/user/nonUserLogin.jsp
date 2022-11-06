<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script src="${contextpath}/resources/js/member/login.js"></script>
<%-- <link rel="stylesheet" href="${contextpath}/resources/css/member/nonUserLogin.css" />
 --%></head>
<head>
</head>

<div class="tab_menu">
  <ul class="list">
    <li class="is_on">
      <a href="/login" class="btn">회원 로그인 </a>
    </li>
    <li>
      <a href="/nonUserLogin" class="btn">비회원 로그인 </a>
	<div>
	<h1>비회원 로그인</h1>
	<form:form action="/nonUserLogin" method="post" modelAttribute="loginUserInfo" autocomplete="off">
		<div class="form-group">
			<label for="email">Email</label>
			<form:input path="email" type="text" class="form-control" id="email"
				placeholder="Enter email" />
		</div>
		<div class="form-group">
			<label for="phone">Phone Number</label>
			<form:input path="phone" type="text" class="form-control" id="phone"
				placeholder="Phone Number" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	 <li>
		  <a href="/signup" class="btn">회원가입 </a>
    </li>
	</form:form>
	</div>
    </li>
  </ul>
</div>