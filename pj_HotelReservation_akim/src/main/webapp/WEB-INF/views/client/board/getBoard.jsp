<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의 게시판 상세 내역</title>
	<link rel="stylesheet" href="../css/board.css?ver=1">
	<script type="text/javascript" src="../script/script.js"></script>
	<style>
		#btn{
			margin-top:15px;
			margin-bottom:15px;
			background-color: #382f24;
		    width:120px;
		    height:50px;
		    border: none;
		    font-size:medium;
		    color:#f1ebd5;
			}
		#detailcomment{
			width:50%;
			height:100px;
			text-align:center;
			margin:40px auto;
			font-size:x-large;
		}
		
		.inquiryDetail{
			width:70%;
			margin-top:30px;
			margin-bottom:80px;
			border-top: 3px solid #623f30;
			border-collapse: collapse;
		}
		
		.inquiryDetail tr{
			border-bottom:2px solid #e6e6e6;
			padding:10px;
		}
		
		.inquiryDetail tr td{
			border-bottom:2px solid #e6e6e6;
			padding:10px;
			height:30px;
		}
		
		#detail{
			text-align:center;
			width:130px;
			height:40px;
			color:#967e5d;
		    font-weight:900;
		    background-color:#e6dfc6;
		}
		
		#detailcontent{
			text-align:center;
			width:130px;
			height:440px;
			color:#967e5d;
		    font-weight:900;
		    background-color:#e6dfc6;
		}
		
		#detailtextarea{
			width:100%;
			height:440px;
			font-size:18px;
			border:none
		}
		
		#detailtextarea:focus{
			outline:none;
		}
		
		#comment{
			padding-left: 150px;
		}
		
		#commentWrite{
			width:300px;
			height:120px;
			padding-left: 150px;
		}
		
		#commentBtn{
			width:70px;
			height:25px;
			border: none;
			background-color: #876f55;
			color:#f1ebd5;
		}
		
		#commentWriteBtn{
			position:absolute;
			width:120px; 
			height:50px; 
			background-color: #876f55; 
			color:#f1ebd5;
			border: none;
			margin-top:20px;
			margin-left:25px;
		}
	</style>
</head>

<body>
	<br/><br />
	&nbsp;&nbsp;&nbsp; <h1 style="text-align: center"><font size="20">문의 게시판<br /></font></h1>

	<form action="../board/boardUpdate.jsp">
		<table align="center" class="inquiryDetail">
			<tr>
				<td id="detail">제목</td>
				<td>${dto.getTitle()} <input type="hidden" name="b_title"
					value="${dto.getTitle()}" />
				</td>
				<td id="detail">No</td>
				<td>${dto.getId()} <input type="hidden" name="b_number"
					value="${dto.getId()}" />
				</td>
			</tr>
			<tr>
				<td id="detail">작성자</td>
				<td>${dto.getName()} <input type="hidden" name="b_writer"
					value="${dto.getName()}" />
				</td>
				<td id="detail">작성일</td>
				<td>${dto.getCreated_at()} <input type="hidden" name="b_time"
					value="${dto.getCreated_at()}" />
				</td>

			</tr>
			<tr>
				<td id="detailcontent">내용</td>
				<td colspan="3"><textarea rows="5" cols="40"
						id="detailtextarea" readonly="readonly" name="b_content">${dto.getContent()}</textarea>
				</td>
			</tr>
			<tr align="center">
				<td colspan="4">
						<input type="submit" id="btn" value="수정" />
						<input type="button" id="btn" value="삭제"
							onclick="location.href='boardremove?id=${dto.getId()}'" />
						<input type="button" id="btn" value="목록"
							onclick="location.href='boardlist'" />
				</td>
			</tr>

			<!-- 작성된 댓글들 보여주기 -->
			<!--
			<c:forEach items="${calist }" var="comment">
				<tr>
					<td colspan="4" id="comment">
						${comment.c_writer} | ${comment.c_time }<br/>
						
						<div id="showContent${comment.c_number}" style="white-space:pre;"><c:out value="${comment.c_comment}"></c:out><br /></div>
						
						<div id="hideContent${comment.c_number}" style="display:none;">
							<form action="CommentUpdate" method="post">
								<textarea rows="6" cols="100" name="c_comment" required="required">${comment.c_comment }</textarea><br />
								<input type="hidden" name="c_number" value="${comment.c_number}" />
								<input type="hidden" name="b_number" value="${comment.b_number}" />
								<input type="submit" value="수정 완료" id="commentBtn" />
								<input type="button" value="취소" onclick="showDesc(${comment.c_number})" id="commentBtn" />
							</form>
						</div>
					
						<c:if test="${comment.c_writer eq sessionScope.u_idKey }">
						<div id="showContent${comment.c_number}">
							<input type="button" value="수정" id="commentBtn" onclick="showDesc(${comment.c_number})" />
							<input type="button" value="삭제" id="commentBtn" onclick="location.href='CommentDelete?c_number=${comment.c_number}&b_number=${comment.b_number }'" />
						</div>
					</c:if>
					</td>
				</tr>	
			</c:forEach>
			-->

			<!-- 글주인일 경우만 댓글 작성 가능 --> 
			<!--
			<c:if test="${flag}">

				<tr>
					<td colspan="4" id="commentWrite">
						<form action="CommentWrite" method="post">
							<textarea rows="6" cols="100" name="c_comment"
								required="required" placeholder="소중한 댓글을 작성해주시길 바랍니다."></textarea>
							<input type="hidden" name="id" value="${dto.getId()}"> <input
								type="hidden" name="name" value="${dto.getName()}"> <input
								type="submit" value="댓글 작성" id="commentWriteBtn" />
						</form>
					</td>
				</tr>
			</c:if>
			-->
		</table>
	</form>
</body>
</html>