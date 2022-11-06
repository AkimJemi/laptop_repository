<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- 컨트롤러에서 받을 링크 이름 -->
<form action="realinsert" method="post" enctype="multipart/form-data">

<input type="text" name="room_name">
<input type="text" name="max_count">
<textarea class="form-control" name="info" id="contents" required></textarea>
<input type="text" name="options">
<input type="text" name="images">
<input type="file" name="upload_file" accept=".jpg, .jpeg, .png" onchange="checkSize(this)">
<input type="text" name="price">

<div style="text-align : center;">
	<button class="btn btn-secondary" type="submit">방 등록</button>
	<button onclick="location.href='/admin/room/roominfolist'" class="btn btn-secondary" type="button">돌아가기</button>
</div>
</form>