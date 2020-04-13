<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원정보변경</h1>
	<hr />
	<form action="hewon_update" method="post" >
	<%-- 입력태그에만 전달되므로 id는 전달이 안됨!! 그래서 설정한것~~~ 입력받지말고 전달하기 --%>
	<%-- 회원정보를 변경하기 위해 반드시 아이디를 요청처리 메소드에 반드시 전달 --%>
	<%-- => Session Scope를 이용하므로 아이디 전달 불필요 --%>
	<%-- <input type="hidden" name="id" value="${hewon.id }" /> --%>
		<table>
			<tr>
				<td>아이디</td>
				<td>
					${hewon.id }
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pw" id="pw"/>
					<span id="pwMsg" class="error"></span>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" id="name" value="${hewon.name}"/>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" id="email" value="${hewon.email }"/>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남자<input type="radio" name="gender" value="남자" checked/>
					&nbsp;&nbsp;
					여자<input type="radio" name="gender" value="여자" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">회원변경</button>
				</td>
			</tr>								
		</table>
	</form>	
</body>
</html>