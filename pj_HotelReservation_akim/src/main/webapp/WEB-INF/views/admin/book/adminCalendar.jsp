<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>Admin Calendar</title>
<link rel="stylesheet" href="${contextpath}/resources/css/adminBook.css" />
<script src="/resources/js/adminBook.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinnotech.hotel.dto.BookingsDTO"%>
<%@page import="java.util.ArrayList"%>
<style type="text/css">
</style>
<!-- 수정 사항 -->
<!-- 방번호 링크 클릭 - 수정 버튼 - 뒤로가기 -->
<link href='${contextpath}/resources/fullcalendar/fullcalendar.css'
	rel='stylesheet' />
<script src='${contextpath}/resources/fullcalendar/fullcalendar.js'></script>
<%
String no = "", room = "", deleteFlag = "";
%>
<div class="d-flex justify-content-around mx-3" style="min-height: 700px;">
	<!-- roomList -->
	<div class="w-25 h-75 border mx-3" style="min-height: 600px;">
		<form id="adminCalendar" action="/admin/calendar/" method="POST">
			<div class="input-group w-100 my-3">
				<c:if test="${paging != null}">
					<c:if test="${paging.title eq 'no'}">
						<%
						no = "selected";
						%>
					</c:if>
					<c:if test="${paging.title eq 'room'}">
						<%
						room = "selected";
						%>
					</c:if>
				</c:if>

				<select name="title" class="form-select form-select-sm"
					aria-label=".form-select-sm example">
					<option value="">::검색::</option>
					<option value="no" <%=no%>>방번호</option>
					<option value="room" <%=room%>>방이름</option>
				</select> <input type="text" name="content" class="form-control"
					value="${paging.content}">

				<c:if test="${paging != null}">
					<c:if test="${paging.title eq 'no'}">
						<%
						no = "selected";
						%>
					</c:if>
					<c:if test="${paging.title eq 'room'}">
						<%
						room = "selected";
						%>
					</c:if>
				</c:if>
				<input type="submit" class="btn btn-outline-primary" value="검색">
				<input id="currentPage" type="hidden" name="currentPage"
					value="${paging.currentPage }">
				<c:if test="${paging.deleteFlag eq true}">
					<%
					deleteFlag = "checked";
					%>
				</c:if>
				<div class="form-control">
					<input class="form-check-input" type="checkbox" name="deleteFlag"
						<%=deleteFlag%> id="deleteFlag"> <label
						class="form-check-label" for="deleteFlag">삭제</label>
				</div>

			</div>
		</form>
		<div style="min-height:500px; max-height:500px;">
			<c:forEach var="room" items="${roomInfoList}">
				<div class="d-flex justify-content-around " style="width: 100%">
					<div>${room.id }</div>
					<div>
						<a class="text-danger" onclick="adminCalendarLink('${room.id }')">${room.roomName }</a>객실
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="d-flex justify-content-center my-2"
			style="max-height: 200px;">
			<div class="row">
				<div class="btn-group me-2 col text-center" role="group"
					aria-label="Second group">
					<c:if test="${paging.currentPage > 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminRoomCalendarPaging(1)">◁◁</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminRoomCalendarPaging(${paging.currentPage-5})">◁</button>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage}"
						var="page">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminRoomCalendarPaging(${page})">${page }</button>
					</c:forEach>
					<c:if test="${paging.totalPage > paging.startPage + 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminRoomCalendarPaging(${paging.currentPage+5})">▷</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminRoomCalendarPaging(${paging.totalPage})">▷▷</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- roomDetail -->
	<div class="w-25 h-75 border mx-3" style="min-height: 600px">
		<c:if test="${roomInfo !=null }">
			<div class="d-flex justify-content-center">
				<form action="/admin/room/update/${roomInfo.id}" method="GET">
					<div>
						<div class="d-flex justify-content-around my-3">
							<h2>회원 정보</h2>
						</div>
						<div class="d-flex justify-content-around my-3">
							<label for="roomId" class="col-sm-3 col-form-label">번호 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="roomId"
									value="${roomInfo.id }"
									onclick="location.href='/admin/room/detail/${roomInfo.id }'"
									readonly>
							</div>
						</div>
						<div class="d-flex justify-content-around my-3">
							<label for="roomName" class="col-sm-3 col-form-label">방이름</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="roomName"
									value="${roomInfo.roomName }" readonly>
							</div>
						</div>
						<div class="d-flex justify-content-around my-3">
							<label for="info" class="col-sm-3 col-form-label">정보</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="info"
									value="${roomInfo.info }" readonly>
							</div>
						</div>
						<div class="d-flex justify-content-around my-3">
							<label for="price" class="col-sm-3 col-form-label">가격</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="price"
									value="${roomInfo.price}" readonly>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="btn-wrap">
								<input value="수정" class="btn btn-primary" type="submit">
							</div>
						</div>
					</div>
				</form>
			</div>
		</c:if>
	</div>
<!-- roomCalendar -->
<div class="w-50 h-100 border">
<script type="text/javascript">
function adminCalendarLink(val){
	$('#currentPage').val('${paging.currentPage}');
	$("#adminCalendar").attr("action", "/admin/calendar/"+ val);
	document.getElementById('adminCalendar').submit();
}
function adminRoomCalendarPaging(val){
	$('#currentPage').val(val);
	$("#adminCalendar").attr("action", "/admin/calendar/"+ '${roomInfo.id }');
	document.getElementById('adminCalendar').submit();
}
</script>
<c:if test="${bookingDates != null }">
<%
ArrayList<BookingsDTO> bookList = (ArrayList<BookingsDTO>) request.getAttribute("bookingDates");
%>
<script>
document.addEventListener('DOMContentLoaded', function() {
	var id= null;
	var result;
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl,
		{
			initialView : 'dayGridMonth',
			locale: 'ja',
			selectable: true,
			headerToolbar : {
			center : 'addEventButton'
			}, events : [
<%
for (BookingsDTO bookInfo : bookList) {
	String color = "", textColor = "", title = "";
	title = bookInfo.getRoomName() + " - " + bookInfo.getUserName();
	if (bookInfo.isDeleteFlag()) {
		color = "red";
		textColor = "white";
	} else if (bookInfo.isCancelFlag()) {
		color = "orange";
		textColor = "black";
	} else if (bookInfo.isPayFlag()) {
		color = "yellow";
		textColor = "orange";
	}

	if (!bookList.isEmpty()) {%>
		{
			title : '<%=title%>',
			start : '<%=bookInfo.getStartDate()%>',
			end : '<%=bookInfo.getEndDate()%>',
			url: '/admin/book/detail/<%=bookInfo.getId()%>',
			color : '<%=color%>', 
			textColor : '<%=textColor%>' 
		},
	<%} else {%>
			{
			title : '<%=title%>',
			start : '<%=bookInfo.getStartDate()%>',
			end : '<%=bookInfo.getEndDate()%>',
			url: '/admin/book/detail/<%=bookInfo.getId()%>',
			color : '<%=color%>',
			textColor : '<%=textColor%>' 
		},
	<%}
}%>  
		]
	 , dateClick: function(info) {
		console.log("dateClick : " + info.dateStr);
	} , select: function(info){
		console.log("select : " + info.startStr + " - " + info.endStr);
		checkDateAvailable(info.startStr, info.endStr);
	}
});
function checkDateAvailable(str, end){
var id = document.getElementById("roomId").value;
	$.ajax({
		type:'POST',
		url:'calendarSelect',
		data:{"startDate": str, "endDate": end, "id": id},	
		dataType:'json',
		async:false
	})
	.done(function(data){
		alert(data.message);
	})
	.fail(function(error){
		alert("エラー　：　" + error);
	})
   };
   calendar.render();
}); 
</script>
</c:if>
		<div class="ForCalender d-flex " style="min-height: 600px;">
			<div id='calendar' class="w-100 h-100 mx-auto my-auto"></div>
		</div>
	</div>
</div>