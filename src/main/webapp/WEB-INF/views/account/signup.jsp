<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>signup</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="<%=request.getContextPath()%>/signup">
		<div>
			<input type="text" name="id">
		</div>
		<div>
			<input type="password" name="pw">
		</div>
		<div>
			<input type="email" name="email">
		</div>
		<input type="radio" name="gender" value="male" id="male" checked>
		<label for="male">남성</label>
		<input type="radio" name="gender" value="female" id="female">
		<label for="female">여성</label><br>
		<button type="submit">제출</button>
	</form>
	<script type="text/javascript">
	var check = ${fail};
	if(check == true)
		alert('중복된 아이디 입니다');
	</script>
</body>
</html>
