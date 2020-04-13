<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원목록</h1>
	<hr />
	<!-- 반복문을 사용하기 위해서는 foreach필요 >> taglib를 사용하여 core라이브러리 사용 -->
	<!-- memberList로 저장된 객체들을 foreach를 사용하여 member로 저장하고 값을 하나씩 출력 -->
	<c:forEach var="member" items="${memberList }">
		<div>
			아이디 = ${member.id }, 이름 = ${member.name }, 이메일 = ${member.email }
		</div>
	</c:forEach>

</body>
</html>