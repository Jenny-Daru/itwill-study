<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<hr />
	<%-- AJAX 이용 =>        type : "POST"
	                       headers: content-type => multipart/form-data로 꼬옥 설정할 것!!! --%>
	
	<%-- ★★★★★왕 중요★★★★★ --%>
	<%-- 파일을 입력받아 전달하기 위해 요청방식(method 속성)  : "POST"
	                                   전달형태(enctype 속성) : "multipart/form-data" --%>     
	<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>업로더</td>
			<td><input type="text" name="uploader"/></td>
		</tr>
		<tr>
			<td>업로드 파일</td>
			<td><input type="file" name="uploadFile"/></td>
		</tr>		
		<tr>
			<td colspan="2">
				<button type="submit">업로드</button>
			</td>
		</tr>
	</table>	
	</form>
</body>
</html>