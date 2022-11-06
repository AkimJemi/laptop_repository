<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${contextpath}/resources/css/adminBook.css" />
<script src="/resources/js/adminBook.js"></script>
<title>${room }번방예약관리상세정보</title>
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
	<form action="/admin/book/update/${book.id }" method="POST"
		class="my-5 mx-5 px-5 adminBookDetail">

		<div class="form-group row m-3 mx-5">
			<label for="bookNo" class="col-sm-2 col-form-label w-5 admin-font">예약번호:</label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" id="bookNo"
					placeholder="BookNo" readonly name="id" value="${book.id }">
			</div>
			<label for="userName" class="col-sm-2 col-form-label w-5">예약자:</label>
			<div class="col-sm-5 w-25">
				<input type="text" class="form-control" id="userName"
					placeholder="Customer" name="userName" value="${book.userName}"
					readonly>
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="roomName" class="col-sm-2 col-form-label w-5">방이름:</label>
			<div class="col-sm-10 w-25">
				<input type="text" class="form-control" id="roomName"
					name="roomName" placeholder="RoomName" value="${book.roomName }"
					readonly>
			</div>
			<label for="options" class="col-sm-2 col-form-label w-5">옵션:</label>
			<div class="col-sm-10 w-25">
				<c:choose>
					<c:when test="${form eq 'update' }">
						<c:choose>
							<c:when test="${not empty options0 }">
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options0}" var="option">
										<option id="${option.bookingCode}" ${option.selected }
											value="${option.bookingCode}">${option.info }</option>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options }" var="option">
										<option id="${option.bookingCode}"
											value="${option.bookingCode}">${option.info }</option>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty options1}">
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options1}" var="option">
										<option id="${option.bookingCode}" ${option.selected }
											value="${option.bookingCode}">${option.info}</option>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options }" var="option">
										<option id="${option.bookingCode}"
											value="${option.bookingCode}">${option.info }</option>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty options2 }">
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options2}" var="option">
										<option id="${option.bookingCode}" ${option.selected }
											value="${option.bookingCode}">${option.info}</option>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name="options" class="form-control">
									<option value="">::옵션 선택::</option>
									<c:forEach items="${options }" var="option">
										<option id="${option.bookingCode}"
											value="${option.bookingCode}">${option.info }</option>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${not empty selectedOption}">
								<c:forEach items="${selectedOption }" var="option">
									<input type="text" name="options" readonly
										value="${option.info}" class="form-control d-inline-block">
								</c:forEach>
							</c:when>
							<c:otherwise>
								<input type="text" readonly value="なし"
									class="form-control d-inline-block">
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="price" class="col-sm-2 col-form-label w-5">가격:</label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" id="inputEmail3"
					placeholder="Price" name="price" value="${book.price}" <%=form %>>
			</div>
			<label for="payFlag" class="col-sm-2 col-form-label w-5">결재유무:</label>
			<div class="col-sm-10 w-25">
				<c:choose>
					<c:when test="${book.payFlag eq true}">
						<%
						trueFlag = "selected";
						%>
					</c:when>
					<c:otherwise>
						<%
						falseFlag = "selected";
						%>
					</c:otherwise>
				</c:choose>
				<select <%=form%> class="form-select form-select-md"
					aria-label=".form-select-sm example" name="payFlag" <%=disabled%>>
					<option value="true" <%=trueFlag%>>결제완료</option>
					<option value="false" <%=falseFlag%>>미결제</option>
				</select>
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="adultCnt" class="col-sm-2 col-form-label w-5">성인
				(수):</label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" placeholder="AdultNum"
					name="adultCnt" value="${book.adultCnt}" min="0" max="5" <%=form %>>
			</div>
			<label for="childrenCnt" class="col-sm-2 col-form-label w-5">아동
				(수):</label>
			<div class="col-sm-10 w-25">
				<input type="number" class="form-control" placeholder="ChildNum"
					name="childrenCnt" value="${book.childrenCnt}" min="0" max="5"
					<%=form %>>
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="startDate" class="col-sm-2 col-form-label w-5">체크인:</label>
			<div class="col-sm-10 w-25">
				<input type="date" class="form-control" <%=form %> name="startDate"
					value="${book.startDate}">
			</div>
			<label for="endDate" class="col-sm-2 col-form-label w-5">체크아웃:</label>
			<div class="col-sm-10 w-25">
				<input type="date" <%=form %> name="endDate" value="${book.endDate}"
					class="form-control">
			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="cancelFlag" class="col-sm-2 col-form-label w-5">취소유무:</label>
			<div class="col-sm-10 w-25">
				<%
				trueFlag = "";
				falseFlag = "";
				%>
				<c:choose>
					<c:when test="${book.cancelFlag eq true}">
						<%
						trueFlag = "selected";
						%>
					</c:when>
					<c:otherwise>
						<%
						falseFlag = "selected";
						%>
					</c:otherwise>
				</c:choose>
				<select <%=form%> class="form-select form-select-md"
					aria-label=".form-select-sm example" name="cancelFlag"
					<%=disabled%>>
					<option value="true" <%=trueFlag%>>취소완료</option>
					<option value="false" <%=falseFlag%>>미취소</option>
				</select>
			</div>
			<label for="inputEmail3" class="col-sm-2 col-form-label w-5">예약상태:</label>
			<div class="col-sm-10 w-25">
				<%
				trueFlag = "";
				falseFlag = "";
				%>
				<c:choose>
					<c:when test="${book.deleteFlag eq false}">
						<%
						deleteFlag = "진행중";
						trueFlag = "selected";
						%>
					</c:when>
					<c:otherwise>
						<%
						deleteFlag = "삭제된 예약";
						falseFlag = "selected";
						%>
					</c:otherwise>
				</c:choose>
				<input type="text" class="form-control" placeholder="deleteFlag"
					value="<%=deleteFlag%>" readonly>

			</div>
		</div>
		<div class="form-group row m-3 mx-5">
			<label for="inputEmail3" class="col-sm-2 col-form-label w-5">생성일:</label>
			<div class="col-sm-10 w-25">
				<input type="text" class="form-control"
					value="${book.createdAtForView}" readonly />
			</div>
			<label for="inputEmail3" class="col-sm-2 col-form-label w-5">갱신일:</label>
			<div class="col-sm-10 w-25">
				<input type="text" class="form-control"
					value="${book.updatedAtForView} - ${book.updatedAtForTime}"
					readonly />
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="btn-wrap">
				<c:choose>
					<c:when test="${form eq 'update' }">
						<input value="완료" class="btn btn-primary" type="submit">
						<input value="뒤로" class="btn btn-info" type="button"
							onclick="location.replace('/admin/book/detail/${book.id}')">
					</c:when>
					<c:otherwise>
						<input value="수정" class="btn btn-primary" type="button"
							onclick="adminBookDetailUpdate('${book.id}')">
						<input value="뒤로" class="btn btn-info" type="button"
							onclick="location.replace('${getReturnKind}')">
					</c:otherwise>
				</c:choose>
				<input value="예약취소" class="btn btn-info" type="button"
					onclick="adminBookDetailCancel('${book.id}')">
			</div>
		</div>
	</form>
</div>