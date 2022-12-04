<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="searchReservation" method="get" name="cForm">
	<div class="d-flex justify-content-center"
		style="min-height: 900px; max-height: 900px;">
		<div class="container pt-5">
			<div class="row row-cols-1 row-cols-lg-1 g-1 g-lg-1">
				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="">체크인</span> <input type="text"
							class="form-control" name="checkin"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-default">
					</div>
				</div>
				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="">체크아웃</span> <input
							type="text" class="form-control" name="checkout"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-default">
					</div>
				</div>
				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="">성인</span> <input type="text"
							class="form-control" name="adult"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-default">
					</div>
				</div>
			</div>
			<div class="col">
				<div class="input-group mb-3">
					<span class="input-group-text" id="">어린이</span> <input type="text"
						class="form-control" name="kids" aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-default">
				</div>
			</div>
				<input type="submit" value="체크" id="btn"
					onclick="return reservationCheck()" />
		</div>
	</div>
</form>