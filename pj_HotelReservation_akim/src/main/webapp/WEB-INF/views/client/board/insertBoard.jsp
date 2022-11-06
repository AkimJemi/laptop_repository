<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
<head>
<meta charset="UTF-8">
<title>새 게시글 작성</title>
<script type="text/javascript" src="../script/script.js"></script>
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
#writeTitle{
	width:100%;
	height:35px;
	font-size:20px;
	border:none;
	
}

#writeTitle:focus{
	outline:none;
}

#writeContent{
	width:100%;
	height:300px;
	font-size:20px;
	border:none
}

#writeContent:focus{
	outline:none;
}
</style>
</head>

<body>
	<br/><br />
	&nbsp;&nbsp;&nbsp; <font size="20">문의 게시판 작성</font><br />
		
		<form action="boardlist" name="regForm" method="post">
		<table align="center" class="inquiryDetail">
			<tr>
				<td id="detail">TITLE</td>
				<td><input type="text" name="b_title" maxlength="30" id="writeTitle" placeholder="문의 내용을 상세히 기재해 주시면 정확한 답변에 도움이 됩니다"/></td>
			</tr>
			<tr>
				<td id="detail">CONTENT</td>
				<td><textarea name="b_content" rows="5" cols="40" id="writeContent" placeholder="불건전한 내용(예: 불충분한 증거/귀책 사유에 대한 개인 음해성 등) 또는 광고성 게시물은 사전 통보 없이 삭제 처리될 수 있습니다."></textarea></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" id="btn" value="확인" onclick="return boardCheck()" />
					<input type="reset" id="btn" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>