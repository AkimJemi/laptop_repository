<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<link rel="stylesheet" href="../css/board.css">
<style>
#btn {
	margin-top: 15px;
	margin-bottom: 15px;
	background-color: #382f24;
	width: 120px;
	height: 50px;
	border: none;
	font-size: medium;
	color: #f1ebd5;
}
.inquiryInfo{
	width:70%;
	margin-top:70px;
	margin-bottom:220px;
	border-top: 3px solid #623f30;
	border-collapse: collapse;
}

.inquiryInfo tr{
	border-bottom:2px solid #e6e6e6;
	padding:10px;
}

.inquiryInfo tr td{
	border-bottom:2px solid #e6e6e6;
	padding:10px;
	height:35px;

}

#list > td{
	height:40px;
	color:#967e5d;
    font-weight:900;
    background-color:#e6dfc6;
}

.inquiryInfo a:link {					/* a 태그 클릭 안한 상태 */
	text-align:center; 
	color: black;
	text-decoration : none;	/*밑줄 제거*/
}

.inquiryInfo a:visited { 				/* a 태그 1회 이상 클릭 했을 때 상태 */
 	color: black; 
 	text-decoration: none;
}

.inquiryInfo a:hover { 					/* a 태그에 마우스 올렸을 때 상태 */
 	color: black; 
 	text-decoration: none;	
}

#listcomment{
	width:50%;
	height:100px;
	text-align:center;
	margin: 10px auto;
	font-size:x-large;
}
</style>
</head>
<body>
	<h1 style="text-align: center">문의 게시판</h1>
	<table align="center" width="80%" class="boardInfo">
		<tr align="center" id="list">
			<td align="center">No</td>
			<td align="center">작성자</td>
			<td align="center">제목</td>
			<td align="center">작성일 </td>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td align="center">${board.id}</td>
				<td align="center">${board.name}</td>
				<td align="center"><a href="getBoard.do?seq=${board.id}">${board.title}</a></td>
				<td align="center">${board.created_at}</td>
			</tr>
		</c:forEach>
		<tr align="right">
			<td colspan="4">
				<input type="button" id="btn" value="작성"
				onclick="location.href='../insertBoard.jsp'" />
			</td>
		</tr>
	</table>
			<!-- 
			<form name="listForm" method="POST" action="boardList.jsp">
				<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="left">
							<select name="searchCondition">
								<option value="TITLE">제목
								<option value="WRITER">작성자
							</select> 
							<input type="text" name="searchKeyword" />
							<input type="submit" name="제출" />
						</td>
					</tr>
				</table>
			</form>
			 -->
	<!-- <a href="insertBoard.jsp">새 게시글 등록</a>&nbsp;&nbsp;&nbsp; -->
</body>
</html>