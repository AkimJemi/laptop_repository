<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		
		
	<c:choose>
		<c:when test="${msg != '' }">
			${msg }
		</c:when>
		<c:otherwise>
			<table width="80%" align="center" class="reserveResult">
				<c:forEach items="${totalroom }" var="tr">
					<tr align="center" id="line">
						<td width="30%" id="line"><img src="../data/${tr.getRoom_img() }" width="280" height="200"></td>
						<td width="30%" id="line">
							<table>
								<tr align="center">
									<th>${tr.getRoom_type() }</th>
								</tr>
								<tr align="left">
									<td>객실크기 : ${tr.getRoom_size() }㎡</td>
								</tr>
								<tr align="left">
									<td>최대 수용 인원 : ${tr.getRoom_capacity()}명</td>
								</tr>
							</table>
						</td>
						<td width="25%" id="line"><b><fmt:formatNumber value="${tr. getRoom_price() }" pattern="#,###" />원  (1박)</b></td>
						<td id="line"><input type="button" id="btn2" value="예약하기" onclick="location.href='reservation3.jsp?r_checkin=${param.r_checkin}&r_checkout=${param.r_checkout }&r_adults=${param.r_adults}&r_kids=${param.r_kids }&room_type=${tr.getRoom_type() }&room_img=${tr.getRoom_img()}&room_price=${tr. getRoom_price() }&diffday=${diffday}'"></td>
					</tr>
				</c:forEach>
			</table>	
		</c:otherwise>
	</c:choose>
	
		
		
</body>
</html>