<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
body {
	  padding-top: 70px;
	  padding-bottom: 30px;
}

.title_feild {
	height: 35px;
	background-color: #eeeeee;
	font-size: 15px;
	font-weight: bold;
	width: 100%
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
	margin-left: 6px;
}

textarea:focus {
	outline: none;
}
</style>
<h1 style="text-align: center">공지사항</h1>
<div class="container">
	<div style="width: 60%; margin: auto;">
		<form style="border-top: 2px solid black;" id="form" role="form"
			method="get" action="/admin/notice/update/${notice.id }">
			<div style="width: 100%; border-bottom: solid 1px gray">
				<div
					style="line-height: 30px; width: 20%; float: left; height: 30px; font-weight: bold; background-color: #eeeeee; text-align: center; padding-top: 5px;">
					TITLE</div>

				<div style="margin-left: 20%; height: 36px; width: 100%;">
					<input type="text"
						style="width: 80%; height: 86%; border: none; margin-top: 2px;"
						class="form-control" name="title" value="${notice.title }" readonly>

				</div>
			</div>
			<div style="width: 100%;">
				<div
					style="line-height: 39px; width: 20%; float: left; height: 35px; font-weight: bold; background-color: #eeeeee; text-align: center;">
					작성일</div>
				<div
					style="line-height: 39px; width: 27%; float: left; margin-right: 0px; height: 35px; font-size: 14px; background-color: white; padding-left: 20px; text-align: left;">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${notice.createdAt }" />
				</div>
				<div
					style="line-height: 39px; width: 20%; float: left; height: 35px; font-weight: bold; background-color: #eeeeee; text-align: center;">
					개시기간</div>
				<div
					style="line-height: 39px; width: 27%; float: left; height: 35px; font-size: 14px; background-color: white; padding-left: 20px;">

					<input type="date" name="endDate" class="form-control" readonly>
				</div>

			</div>
			<div>
				<textarea
					style="width: 100%; height: 400px; padding-top: 30px; border: none; border-top: 1px solid gray; border-bottom: 2px solid black"
					class="form-control" rows="5" name="content" readonly>${notice.content }</textarea>
			</div>
			<div style="height: 40px; margin-top: 50px;">
				<button type="submit" class="btn_style" id="btnSave">수정</button>
				<button type="button" class="btn_style" id="btnList" onclick="location.href='/admin/notice/list'">취소</button>
			</div>
		</form>
	</div>
</div>