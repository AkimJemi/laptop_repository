<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>admin.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/res/tags/header.jsp" %>
	<table>
		<tr>${loginedUser.id } 님 환영합니다</tr>
		<tr>
			<th>번호</th>
			<th>예약번호</th>
			<th>예약</th>
			<th>예약상태</th>
			<th>예약확인</th>
			<th>예약취소</th>
		</tr>
		<c:forEach var="book" items="${book }">
			<tr>
				<td>${book.no }</td>
				<td>${book.res_nvm }</td>
				<td>${book.if_res }</td>
				<td>${book.check_res }</td>
				<td><a href="<%=request.getContextPath()%>/res/admin/book/check_res/update.do?no=${book.no }&type=yes">예약확인</a></td>
				<td><a href="<%=request.getContextPath()%>/res/admin/book/check_res/update.do?no=${book.no }&type=no">취소하기</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>