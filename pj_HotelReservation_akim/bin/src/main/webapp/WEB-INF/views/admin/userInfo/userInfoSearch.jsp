<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원정보 검색</title>
</head>
<body>
<script type="text/javascript">
const message = '${requestScope.message}';
if(message){
alert(message);
}
</script>
<% String name ="",phone="",email="";%>
<form id="userSearch" name="userSearch" action="search" class="form-inline">

	<table class="table text-center table-dark table-hover">
			<thead>
				<tr>
					<td>No</td>
					<td>이름</td>
					<td>연락처</td>
					<td>메일주소</td>
					<td>비밀번호재설정</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
			<c:if test="${page != null}">
							<c:if test="${page.searchType eq 'name'}">
								<%name = "selected";%>
							</c:if>
							<c:if test="${page.searchType eq 'phone'}">
								<%phone = "selected";%>
							</c:if>
							<c:if test="${page.searchType eq 'email'}">
								<%email = "selected";%>
							</c:if>
			</c:if>
			<c:forEach var="userInfo" items="${userInfoList }">
				<tr>
					<td>${userInfo.id}</td>
					<td>${userInfo.name}</td>
					<td>${userInfo.phone}</td>
					<td>${userInfo.email}</td>
					<td><input value="비밀번호재설정" type="button" onclick="passwordReset(${userInfo.email})"/></td>
					<td><input value="삭제" type="button" onclick="deleteUser(${userInfo.id})"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<select name="searchType" id="searchType" class="form-control mr-2">
		<option value="">::검색 유형::</option>
		<option value="name" <%=name %>>회원이름</option>
		<option value="phone" <%=phone%>>연락처</option>
		<option value="email" <%=email %>>이메일</option>
	</select>
		
	<input type="text" name="searchKeyword" id="searchKeyword" placeholder="검색어를 입력하세요" 
	class="form-control mr-2" value="${page.searchKeyword}">
	<button class="btn btn-success">검 색</button>
				<input id="currentPage" type="hidden" class="btn btn-secondary w-10 p-1" name="currentPage" value="${page.currentPage }"/>
</form>
	<div class="container">
 		 <div class="row">
		<div class="btn-group me-2 col text-center" role="group" aria-label="Second group">
			<c:forEach begin="${page.startPage }" end="${page.endPage}" var="page">
				<button type="button" class="btn btn-secondary w-10 p-1" onclick="paging(${page })">${page }</button>
			</c:forEach>
		</div>
		</div>
		</div>
<script>
function paging(val){
	$('#currentPage').val(val);
	document.getElementById('userSearch').submit();
	
}
function passwordReset(val){
	alert(val + '로 재설정 비밀번호를 보냅니다.');
	$.ajax({ // ajax 기본형태
		//////////////////// send(가는것)
		url : "/admin/userInfo/passwordReset",
		type : "get",
	//	data : "t1=XYZ&t2=자차카", // 넘겨주는 데이터
		data : {}, //위와동일

		//////////////////// recv
		success : function(data, status, xhr){ 
			alert(data);
		},
		error : function(xhr, status, error) { // (파라미터 생략가능)
			alert("error");
		},
		complete : function(xhr, status) { // (파라미터 생략가능)
			alert("통신종료");
		}
		////////////////////
	});	
		
	
};
function deleteUser(val){
	if(confirm('No : '+ val + '(을)를 삭제하시겠습니까')){
		var searchType = $('#searchType').val(); 
		var searchKeyword = $('#searchKeyword').val(); 
		var currentPage = $('#currentPage').val(); 
		location.href="delete/"+val+"?searchType=" +searchType+ "&searchKeyword="+searchKeyword+"&currentPage="+currentPage;
	}
};
</script>
</body>
</html>