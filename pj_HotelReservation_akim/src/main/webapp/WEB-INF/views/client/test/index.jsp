<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
	<h2>test path index page</h2>
	<hr/>
	<div>
		<p>list</p>
		<ul>
			<c:forEach items="${list}" var="item" varStatus="status">
				<li>${item.name}</li>
			</c:forEach>
		</ul>
	</div>
</div>

