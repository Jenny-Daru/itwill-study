<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- error메세지를 응답하는 JSP 문서 --%>
<%-- => [로그인 페이지 이동]을 클릭한 경우 로그인정보 입력페이지(/userinfo/login) 요청(GET) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<style type="text/css">
body {
	text-align: center;
}

.message {
	color: purple;
	font-size: 1.5em;
}
</style>
</head>
<body>
	<h1>Error 페이지</h1>
	<hr />
	<p class="message">프로그램 실행에 예기치 못한 오류 발생!! 비정상적인 방법으로 요청해서 오류가 발생!!</p>
	<button type="button" onclick="location.href='${pageContext.request.contextPath }/userinfo/login">로그인 페이지 이동</button>
</body>
</html>