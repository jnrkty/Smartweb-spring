<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="" method="get">
		<input type="text" name="num">
		<button>전송</button>
	</form>
	${num}
	<br>
	<a href="<%=request.getContextPath()%>/?num=4">4페이지</a>
</body>
</html>
