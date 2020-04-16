<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<!-- name속성은 DTO클래스의 필드명과 똑같이 작성할 것 -->
	<h1>자료실 - 입력페이지</h1>
	<hr />
	<form method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${fileBoard.writer }"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${fileBoard.subject }"/></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">파일전송</button></td>
			</tr>									
		</table>
	</form>
</body>
</html>