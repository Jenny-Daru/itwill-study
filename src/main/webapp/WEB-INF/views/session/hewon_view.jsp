<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원상세정보</h1>
	<hr />
	<ul>
		<li>아이디 = ${hewon.id }</li>
		<li>비밀번호 = ${hewon.pw }</li>
		<li>이름 = ${hewon.name }</li>
		<li>이메일 = ${hewon.email }</li>
		<li>성별 = ${hewon.gender }</li>
	</ul>
	<%-- 회원정보변경전 입력태그 출력 >> hewon_update는 id를 가져와야하고 입력페이지에 출력~ --%>
	<hr />
	<%-- <a href="hewon_update?id=${hewon.id }">회원정보변경</a> --%>
	<%-- id를 전달하지 않아도 회원정보 검색 가능 --%>
	<a href="hewon_update">회원정보변경</a>
</body>
</html>