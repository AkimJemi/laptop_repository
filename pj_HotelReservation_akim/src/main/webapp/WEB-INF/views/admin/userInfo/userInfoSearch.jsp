<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/adminUserInfo.js"></script>
<script type="text/javascript">
const message = '${requestScope.message}';
if (message) {
	alert(message);
}
</script>
<title>회원정보 검색</title>
<%
String name = "", phone = "", email = "";
%>
<div class="d-flex justify-content-center w-100">
	<div class="d-inline-block w-95">
		<div class="d-flex justify-content-center w-80">
			<form id="userSearch" name="userSearch" action="search"
				class="form-inline">
				<div
					style="min-height: 400px; min-width: 600px; background-color: lightgray">
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
									<td><input value="비밀번호재설정" type="button"
										onclick="passwordReset('${userInfo.email}', '${userInfo.id }')" /></td>
									<td><input value="삭제" type="button"
										onclick="deleteUser(${userInfo.id})" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<select name="searchType" id="searchType" class="form-control mr-2">
					<option value="">::검색 유형::</option>
					<option value="name" <%=name%>>회원이름</option>
					<option value="phone" <%=phone%>>연락처</option>
					<option value="email" <%=email%>>이메일</option>
				</select> <input type="text" name="searchKeyword" id="searchKeyword"
					placeholder="검색어를 입력하세요" class="form-control mr-2"
					value="${page.searchKeyword}">
				<button class="btn btn-success">검 색</button>

				<input id="currentPage" type="hidden"
					class="btn btn-secondary w-10 p-1" name="currentPage"
					value="${page.currentPage }" />
			</form>
		</div>
		<div class="container w-50">
			<div class="row">
				<div class="btn-group me-2 col text-center" role="group"
					aria-label="Second group">
					<c:if test="${page.currentPage > 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(1)">◁◁</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.currentPage-5})">◁</button>
					</c:if>
					<c:forEach begin="${page.startPage }" end="${page.endPage}"
						var="page">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page })">${page }</button>
					</c:forEach>
					<c:if test="${page.total > page.startPage + 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.currentPage+5})">▷</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.total})">▷▷</button>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</div>
