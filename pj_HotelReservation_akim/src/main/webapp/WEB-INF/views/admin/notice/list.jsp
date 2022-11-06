<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
th, tr {
	height: 35px;
	border-bottom: 1px solid gray;
}

table {
	border-bottom: 2px solid black;
}

.th_style {
	background-color: #eeeeee;
	text-align: center;
	font-size: 15px;
	font-weight: bold;
}

td {
	font-size: 14px;
	border-bottom: 1px solid gray;
}

.title_td {
	padding-left: 15px;
	text-align: left;
}

.btn_style {
	width: 100px;
	height: 40px;
	background: gray;
	font-size: 20px;
	font-weight: bold;
	color: white;
	border: none;
	float: right;
}
</style>
<title>글쓰기 게시판</title>
</head>
<body>
	<h1 style="text-align: center">공지사항</h1>
	<div class="container">
		<div style="width: 60%; margin: auto;">
			<table style="text-align: center; width: 100%">
				<thead>
					<tr>
						<th class="th_style" style="width: 5%;">No</th>
						<th class="th_style" style="width: 80%;">TITLE</th>
						<th class="th_style" style="width: 15%;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="notice" items="${noticeList }">
						<tr>
							<td style="border-bottom: none;">${notice.id }</td>
							<td class="title_td" style="border-bottom: none;"> <a href="/admin/notice/detail/${notice.id }">${notice.title }</a></td>
							<td style="border-bottom: none;"><fmt:formatDate
									pattern="yyyy-MM-dd" value="${notice.createdAt }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="height: 40px; margin-top: 50px;">
				<button type="button" class="btn_style" id="writeBtn"
					onclick="location.href='./write'">글쓰기</button>
			</div>
		</div>
	</div>
</body>
</html>