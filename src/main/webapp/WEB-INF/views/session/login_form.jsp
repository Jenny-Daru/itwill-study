<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>로그인</h1>
	<hr />
	<form action="login" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<%-- <td><input type="text" name="id" value="${id }"/></td> --%>
				<td><input type="text" name="id" value="${hewon.id }"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">Login</button>
				</td>
			</tr>			
		</table>
	</form>
	<p style="color: purple">${message }</p>


</body>
</html>