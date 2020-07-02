<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/guest/delete" method="get">
		비밀번호 :<input type="password" name="pw">
		<button type="submit">확인</button>
		<input type="hidden" name="no" value=${num }>
	</form>
	<a href="/guestbook3/guest/list">메인으로 돌아가기</a>
</body>
</html>