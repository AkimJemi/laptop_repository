<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date today = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String now = simpleDateFormat.format(today);
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<head>
		<meta charset="UTF-8">
		<title>객실 예약 : 날짜, 인원 선택</title>
	</head>

<body>
	
	<h1>객실예약</h1>
	<br/>
	
		<table align="center" class="reservationList">
			<tr id="list">
				<td id="step1">날짜,인원 선택</td>
				<td id="step2">객실 선택</td>
				<td id="step3">옵션 선택</td>
			</tr>
		</table>
		
		<form action="reservationCheck" method="get" name="cForm">
			<table width="80%" class="reservation1">
				<tr>
					<td>체크인</td>
					<td>체크아웃</td>
					<td width="10%">성인</td>
					<td width="10%">어린이</td>
				</tr>
				<tr align="center">
					<td><input type="date" name="checkin" min='<%=now %>' /></td>
					<td><input type="date" name="checkout" /></td>
					<td><input type="number" name="adults" min="1" value="1"/></td>
					<td><input type="number" name="kids" value="0" min="0" /></td>
					<td><input type="submit" value="검색" id="btn" onclick="return reservationCheck()"/></td>
				</tr>
			</table>
		
		</form>
</body>
</html>