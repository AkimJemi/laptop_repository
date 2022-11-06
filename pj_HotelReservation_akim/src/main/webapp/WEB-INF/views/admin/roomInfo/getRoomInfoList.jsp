<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div style="width: 75%;" align="right">
		<button onclick="location.href='/admin/room/insert'">객실추가</button>
	</div>
	<div>
		<div>
			<c:forEach var="dto" items="${roomInfoList}">
			<div>
				<div style="text-align: right; width:50%; height:1px; display: inline-block;">${dto.images }</div>
				<div style="text-align: left; width:50%; display: inline-block;">
					<%-- ${dto.id } --%>
					<tr>
						<td>객실&nbsp;&nbsp;<a href="detail/${dto.id }">${dto.room_name }호</a></td>
					</tr>
					<br />
					<tr>
						<td>최대 인원 &nbsp;&nbsp;${dto.max_count }&nbsp;명</td>
					</tr>
					<br>
					<tr>
						<td>시설 정보 &nbsp;&nbsp;${dto.info }</td>
					</tr>
					<br>
					<tr>
						<td>방 옵션 &nbsp;&nbsp;${dto.options }</td>
					</tr>
					<br>
					<tr>
						<td>1박 가격 &nbsp;${dto.price }</td>
					</tr>
					<%-- ${dto.delete_flag } --%>
					<br>
					<tr>
						<fmt:formatDate value="${dto.created_at}" type="both" />
					</tr>
					<br>
					<tr>
						<fmt:formatDate value="${dto.updated_at}" type="both" />
					</tr>
					<br> <br>
					<div>
						<div style="width: 75%;" algin="right">
							<button onclick="location.href='/admin/book/detail/${book.id }'">예약관리</button>
							<button onclick="location.href='/admin/room/update/${dto.id }'">객실수정</button>
							<button onclick="location.href='/admin/room/delete/${dto.id }'">객실삭제</button>
						</div>
					</div>
					<br> <br>
				</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
