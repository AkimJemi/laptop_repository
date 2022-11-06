<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<fieldset>
<legend>회원정보수정</legend>
	<form action="/userUpdate" method="post" name="fr">
		이메일 <input type="text" name="email" value="${loginUserInfo.email}"><br>
		이름 <input type="text" name="name" value="${loginUserInfo.name} "><br>
		전화번호  <input type="text" name="name" value="${loginUserInfo.phone} "><br>
	</form>
</fieldset>
</body>