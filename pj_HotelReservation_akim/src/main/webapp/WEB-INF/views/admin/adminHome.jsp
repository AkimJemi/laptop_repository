<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${contextpath}/resources/css/adminBook.css" />
<script src="/resources/js/adminBook.js"></script>
<title>AdminHome</title>
<c:if test="${not empty message}">
	<script type="text/javascript">
	alert('${message}');
	</script>
</c:if>
<div class="container">
	<%
	String no = "", room = "", user = "", date = "", deleteFlag = "";
	%>
	<div class="row d-flex justify-content-center w-100">
		<div class="d-inline-block d-flex row w-95 justify-content-center">
			<div class="d-flex justify-content-center w-80">
				<form id="adminHomeListForm" action="/admin">
					<div class="input-group mb-3 w-100">
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
							<c:if test="${paging.title eq 'user'}">
								<%
								user = "selected";
								%>
							</c:if>
						</c:if>
						<select name="title" class="form-select form-select-sm"
							aria-label=".form-select-sm example">
							<option value="no" <%=no%>>예약번호</option>
							<option value="room" <%=room%>>방이름</option>
							<option value="user" <%=user%>>고객</option>
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
							<c:if test="${paging.title eq 'user'}">
								<%
								user = "selected";
								%>
							</c:if>
						</c:if>
						<input type="submit" class="btn btn-outline-primary" value="검색">
						<input id="currentPage" type="hidden" name="currentPage"
							value="${paging.currentPage }">
					</div>
				</form>
			</div>
			<div class="w-75" style="min-height: 400px">
				<table class="table text-center table-dark table-hover">
					<thead>
						<tr>
							<td>예약번호</td>
							<td>방이름</td>
							<td>예약자</td>
							<td>성인예약자수</td>
							<td>아이예약자수</td>
							<td>체크인일</td>
							<td>체크아웃일</td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty bookList }">
								<tr>
									<td colspan="8">오늘 예약고객이 없습니다</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="book" items="${bookList}">
									<tr>
										<td><a href="/admin/book/detail/${book.id }">${book.id }</a></td>
										<td><a href="/admin/room/detail/${book.roomId }">${book.roomName}</a></td>
										<td>${book.userName }</td>
										<td>${book.adultCnt}</td>
										<td>${book.childrenCnt}</td>
										<td>${book.startDate}</td>
										<td>${book.endDate}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-center w-100">
				<div class="row">
					<div class="btn-group col text-center" role="group"
						aria-label="Second group">
						<c:if test="${paging.currentPage > 3}">
							<button type="button" class="btn btn-secondary w-10 p-1"
								onclick="adminHomePaging(1)">◁◁</button>
							<button type="button" class="btn btn-secondary w-10 p-1"
								onclick="adminHomePaging(${paging.currentPage-5})">◁</button>
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
							var="page">
							<button type="button" class="btn btn-secondary w-10 p-1"
								style="max-width: 100px" onclick="adminHomePaging(${page})">${page}</button>
						</c:forEach>
						<c:if test="${paging.totalPage > paging.startPage + 3}">
							<button type="button" class="btn btn-secondary w-10 p-1"
								onclick="adminHomePaging(${paging.currentPage+5})">▷</button>
							<button type="button" class="btn btn-secondary w-10 p-1"
								onclick="adminHomePaging(${paging.totalPage})">▷▷</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>