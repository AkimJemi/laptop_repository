<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="searchReservation" method="get" name="cForm">
	<div class="d-flex justify-content-center"
		style="min-height: 900px; max-height: 900px;">
		<div class="container pt-5">
			<div class="row row-cols-1 row-cols-lg-1 g-1 g-lg-1">
				<c:forEach var="reservation" items="${reservationList }">
					<div><a href="./${reservation.id }">${reservation.id }</a>, ${reservation.adultCnt }, ${reservation.childrenCnt }, ${reservation.startDate }, ${reservation.endDate }</div>
				</c:forEach>
				<input type="submit" value="체크" id="btn"
					onclick="return reservationCheck()" />
			</div>
		</div>
	</div>
</form>