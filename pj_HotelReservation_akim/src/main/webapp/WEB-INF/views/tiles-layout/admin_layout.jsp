<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var = "contextpath" value = "<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin Home</title>
		
		<link rel="stylesheet" href="${contextpath}/resources/lib/bootstrap-5.0.2-dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${contextpath}/resources/css/common.css" />
		
		<script src="${contextpath}/resources/lib/jquery-3.6.1.min.js"></script>
		<script src="${contextpath}/resources/lib/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js"></script>
		<script src="${contextpath}/resources/js/common.js"></script>
		
	</head>
	<body>
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer"/>
	</body>
</html>



