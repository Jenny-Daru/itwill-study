<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 입력페이지에서 처리페이지를 요청할 때 입력값을 전달하기 전에 입력값에 대한 유효성 검사 필수
	  => JavaScript 또는 jQuery 이용 ,jQuery => 라이브러리 이용
	  => JavaScript 언어는 클라이언트의 브라우저에서 동작되므로 유효성 검사에 대한 문제점 발생 가능
	  => 입력값을 전달받는 요청처리 메소드에서도 유효성 검사를 하는것을 권장 - Java  --%>
	  <%-- JavaScript는 Ajax로 검사 //  DB도 검사 => 서비스에서!! --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>♥회원등록♥ - HTML Form</h1>
	<hr />
	<%-- jQuery 사용 => 태그 id 이용(편리) --%>
	<form action="valid_html" method="post" id="form">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" id="id" value="${hewon.id }"/>
				<span id="idMsg" class="error">${idMsg }</span>
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
				<span id="nameMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email" id="email" value="${hewon.email }"/>
				<span id="emailMsg" class="error"></span>
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
				<button type="submit">회원등록</button>
			</td>
		</tr>								
	</table>
	</form>
	
	<script type="text/javascript">
	/*
	if(${hewon.gender}!=null) {
		
	}
	
	$("#form").submit(function() {
		$(".error").text("");
		if($("#id").val()=="") {
			$("#idMsg").text("아이디를 입력해조요.");
			$("#id").focus();
			//기본이벤트 안되기 => submit안됨
			return false; 
		}
		
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(!idReg.test($("#id").val())) {
			$("#idMsg").text("아이디를 형식에 맞게 입력해쥴래??");
			$("#id").focus();
			return false;
		}
		if($("#pw").val()=="") {
			$("#pwMsg").text("비밀번호를 입력해조요.");
			$("#pw").focus();
			return false;
		}
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(!passwdReg.test($("#pw").val())) {
			$("#pwMsg").text("비밀번호를 형식에 맞게 입력해쥴래??");
			$("#pw").focus();
			return false;
		}

		if($("#name").val()=="") {
			$("#nameMsg").text("이름을 입력해조요.");
			$("#name").focus();
			return false;
		}
		var nameReg=/^[가-힣]{2,10}$/g;
		if(!nameReg.test($("#name").val())) {
			$("#nameMsg").text("이름을 형식에 맞게 입력해쥴래??");
			$("#name").focus();
			return false;
		}

		if($("#email").val()=="") {
			$("#emailMsg").text("이메일을 입력해조요.");
			$("#email").focus();
			return false;
		}
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(!emailReg.test($("#email").val())) {
			$("#emailMsg").text("이메일을 형식에 맞게 입력해쥴래?.");
			$("#email").focus();
			return false;
		}
	});	
		*/
	</script>
	

</body>
</html>













