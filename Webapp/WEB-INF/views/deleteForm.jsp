<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/guest/delete/${num }" method="get">
		비밀번호 :<input type="password" name="pw">
		<button type="submit">확인</button>
	</form>
	<a href="${pageContext.request.contextPath }/guest/list">메인으로 돌아가기</a>
</body>
</html>