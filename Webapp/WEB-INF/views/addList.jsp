<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/guest/insert" method="get">
		<table border="1" width="500" height="100">
			<tbody>
				<tr>
					<td>이름 <input type="text" name="name"></Td>
					<td>비밀번호 <input type="text" name="pw"></td>
				</tr>
				<tr height="120">
					<td colspan="2"><textarea rows="8" style="width: 90%;"
							name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">확인</button></td>
				</tr>
					
			</tbody>
		</table>
	</form>

	<br>
	<c:forEach items="${gList }" var="gList">
		<table border="1" width="500" height="75">
			<tr>
				<td>${gList.no }</td>
				<td>${gList.name }</td>
				<td>${gList.reg_date }</td>
				<td><a href="${pageContext.request.contextPath }/guest/deleteForm?num=${gList.no }">삭제</a></td>
			</tr>
			<tr height="50">
				<td colspan="4">${gList.content }</td>
			</tr>
		</table>
		<br>
	</c:forEach>

	<c:if test="${count == 0}">
		<h1>비밀번호가 틀렸습니다.</h1>
	</c:if>

</body>
</html>