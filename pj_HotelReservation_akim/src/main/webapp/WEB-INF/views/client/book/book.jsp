<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>Client Book Main Page</title>



<input value="예약하기" type="button"
	onclick="location.href='/client/book/'" />

<c:forEach var="dto" items="${roomInfoList}">
	<div>
		<div
			style="text-align: right; width: 50%; height: 1px; display: inline-block;">${dto.images }</div>
		<div style="text-align: left; width: 50%; display: inline-block;">
			객실&nbsp;&nbsp;<a href="/detail/${dto.id }">${dto.id }호</a> <br />
			최대 인원 &nbsp;&nbsp;${dto.max_count }&nbsp;명 <br> 시설 정보
			&nbsp;&nbsp;${dto.info } <br> 방 옵션 &nbsp;&nbsp;${dto.options } <br>
			1박 가격 &nbsp;${dto.price }
			<br>
			<fmt:formatDate value="${dto.created_at}" type="both" />
			<br>
			<fmt:formatDate value="${dto.updated_at}" type="both" />
			<br> <br>
			<div>
				<div style="width: 75%;">
					<button onclick="location.href='/client/book/${dto.id}'">예약</button>
				</div>
			</div>
			<br> <br>
		</div>
	</div>
</c:forEach>
