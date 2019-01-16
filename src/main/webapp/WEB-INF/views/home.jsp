<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<%--컨트롤러에서 전달한 데이터를 받기 위해 ${컨트롤러에서전달한이름} 을 사용한다--%>  
<P>  The time on the server is ${serverTime}. </P>
<!-- jsp에서 컨트롤러로 데이터를 전달하려면 form태그를 이용 -->
<form method="post" action="<%= request.getContextPath() %>/">
<!-- 전달하려는 데이터가 있는 태그의 속성 name을 입력한다 -->
	<input type="text" name="name">
	<button>제출</button>
</form>
</body>
</html>
