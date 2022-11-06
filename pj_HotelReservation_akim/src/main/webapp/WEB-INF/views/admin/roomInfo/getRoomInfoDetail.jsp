<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tbody>
	<table>
	<tr>
		<div style="width: 75%;" align="right"><button onclick="history.back()">돌아가기</button></div>
		<td></td>
	</tr>
	</table>
	<tr>
		<th>
			<tr colspan="7">
				${roomInfoDetail.images }
			</tr>
				<%-- ${roomInfoDetail.id } --%>
			<tr>
				<td>객실&nbsp;&nbsp; ${roomInfoDetail.room_name }호</a></td>
			</tr>
			<br/>
			<tr>
				<td>최대 인원 &nbsp;&nbsp;${roomInfoDetail.max_count }&nbsp;명</td>
			</tr>
			<br>
			<tr>
				<td>시설 정보 &nbsp;&nbsp;${roomInfoDetail.info }</td>
			</tr>
			<br>
			<tr>
				<td>방 옵션 &nbsp;&nbsp;${roomInfoDetail.options }</td>
			</tr>
			<br>
			<tr>
				<td>1박 가격 &nbsp;${roomInfoDetail.price }</td>
			</tr>
				<%-- ${roomInfoDetail.delete_flag } --%>
			<br>
			<tr>
				<fmt:formatDate value="${roomInfoDetail.created_at}" type="both"/>
			</tr>
			<br>
			<tr>
				<fmt:formatDate value="${roomInfoDetail.updated_at}" type="both"/>
			</tr>
			<br><br>
			
			안내문
			
			<div>
				<div style="width: 75%;" algin="right">
				<button onclick="location.href='/admin/book/detail/${book.id }'">예약관리</button>
				<button onclick="location.href='/admin/room/update/${roomInfoDetail.id }'">객실수정</button>
				<button onclick="location.href='/admin/room/delete/${roomInfoDetail.id }'">객실삭제</button>
				</div>
			</div>
			<br><br>
		</th>
		<td></td>
	</tr>
</tbody>