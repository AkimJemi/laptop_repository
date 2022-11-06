<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script src="${contextpath}/resources/js/member/memberInput.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/signup.css" />
</head>
<body>
	<div class="container">
	<ul>
	<li>
      <a href="/signup" class="btn">회원으로 가입 </a>
      </li>
      <li>
      <a href="/nonUserSignup" class="btn">비회원으로 가입 </a>
      </li>
      </ul>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">회원으로 가입</h1>
				</div>
				<div class="panel-body">
					<form:form action="/insertMember" method="post" modelAttribute="userInfo" autocomplete="off">
							<div class="form-group">
								<form:label path="email">이메일(최소 8자 최대 30자)</form:label>
								<form:input type="email" path="email" class="form-control" id="email" name="email" required="required" maxlength="30" oninput="emailCheck();" />
								<span id="olmessage"></span>
								<p id="email-warning-message"></p>
								<p id="email-overlapse-message"></p>
 							</div>
							<div class="form-group">
								<form:label path="password">비밀번호(최소8자 최대16자)</form:label>
								<form:password path="password" required="required" maxlength="16"/>
							<p id="password-warning-message"></p>
							</div>
							<div class="form-group">
								<form:label path="confirmPassword">비밀번호 확인</form:label>
								<form:password path="confirmPassword" required="required" maxlength="16"/>
							<p id="confirm-password-warning-message"></p>
							</div>
							<div class="form-group">
								<form:label path="name">이름(최소2자 최대20자)</form:label>
								<form:input type="text" path="name" required="required" maxlength="20"/>
							<p id="name-warning-message"></p>
							</div>
							<div class="form-group">
								<form:label path="phone">전화번호('-'없이 최대11자)</form:label>
								<form:input type="text" min="1" path="phone" required="required" maxlength="11" oninput="phoneCheck();"/>
								<span id="phmessage"></span>
							<p id="phone-warning-message"></p>
							<p id="phone-overlapse-message"></p>
							</div>
							<div class="form-group">
								<form
									action="/insertMember"
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
				</div>
			</div>
		</div>
	</body>