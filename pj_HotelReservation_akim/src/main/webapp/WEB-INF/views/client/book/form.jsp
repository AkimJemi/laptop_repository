<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Client Book Form</title>
<%
String form = "readonly", disabled = "disabled", trueFlag = "", falseFlag = "", selected = "";
String deleteFlag = "";
int i = 0;
%>
<c:if test="${form eq 'update' }">
	<%
	form = "";
	disabled = "";
	%>
</c:if>
<div class="mx-5 d-flex justify-content-center w-100">
	<form action="calendar" method="GET"
		class="my-5 mx-5 px-5 adminBookDetail">

		<div class="form-group row m-3 mx-5">
			<label for="bookNo" class="col-sm-2 col-form-label w-5 admin-font">객실&nbsp;&nbsp;<a
				href="detail/${roomInfo.id }">${roomInfo.id }호</a></label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" id="bookNo"
					placeholder="BookNo" readonly name="id" value="${roomInfo.id }">
			</div>
			<label for="userName" class="col-sm-2 col-form-label w-5">방이름 : </label>
			<div class="col-sm-5 w-25">
				<input type="text" class="form-control" id="userName"
					placeholder="Customer" name="room_name" value="${roomInfo.room_name}"
					readonly>
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="bookNo" class="col-sm-2 col-form-label w-5 admin-font">정보 : </label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" id="bookNo"
					placeholder="BookNo" readonly name="info" value="${roomInfo.info }">
			</div>
			<label for="userName" class="col-sm-2 col-form-label w-5">가격 : </label>
			<div class="col-sm-5 w-25">
				<input type="text" class="form-control" id="userName"
					placeholder="Customer" name="price" value="${roomInfo.price}"
					readonly>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="btn-wrap">

				<input value="수정" class="btn btn-primary" type="submit"> <input
					value="뒤로" class="btn btn-info" type="button"
					onclick="location.replace('${getReturnKind}')">
			</div>
		</div>
	</form>
</div>