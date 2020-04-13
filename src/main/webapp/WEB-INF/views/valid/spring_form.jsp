<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Spring에서 제공해주는 Form태그를 이용하려면 태그라이브러리 필요 --%>
<%-- Spring에서 제공하는 Spring Form태그 라이브러리 포함 => input, radio등 여러 태그들 존재 --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>♥회원등록♥ - Spring Form</h1>
	<hr />
	<%-- Spring Form(Spring) 태그 : 처리페이지를 요청하여 입력값을 전달하는 태그 --%>
	<%-- 							modelAttribute 속성(★필수★) : Command(입력값을 전달받는 JavaBean객체)객체명을 속성값으로 설정, 사용하지 않으면 500에러 발생
																	 => 요청처리 메소드에 반드시 Command객체를 선언해야만 사용 가능 >> 안할시 Error 발생
																	 => 필요 WHY?? 입력값에 대한 유효성 검사에서 오류가 발생된 경우 입력태그에 기존값을 초기값으로 출력되록 제공
																	    기존에는 form태그의 value 속성을 이용하여 기존값을 출력했지만 Spring Form의 modelAttribute속성이 대신 처리 --%>
	<form:form action="valid_spring" method="post" id="form" modelAttribute="hewon">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<%-- input(Spring)태그 : 텍스트를 입력받기 위한 태그 - HTML의 input태그(type 속성값 : text)
											 path속성(★필수★) : HTML의 입력태그의 name속성과 id속성을 동시에 선언하는 효과 제공
											                       =>이거한방으로 input태그의 name,id 한방에 합침
											                      유효성 검사에서 오류가 발생된 경우 value 속성의 기능 제공
											                       => ${hewon.id} 역할 hewon을 통해 id 값
											                      즉!!! modelAttribute와 path만으로 기존 HTML의 name,id,value역할을 다해쥬는거~  --%>
					<form:input path="id"/>
				</td>
				<td>
					<%-- errors(Spring)태그 : Error메세지를 출력하는 태그, path의 속성값과 관련된~
											  path속성값과 동일한 필드에 Error 메세지 출력
											  delimiter속성 : Error메세지가 여러개인 경우 메세지를 구분하기 위한 구분자를 속성값으로 설정 => 기본 구분자 : <br>
											  					=> 클래스의 필드에 Error관련 @어노테이션을 사용할건데 여러개 사용도 가능하므로 그때 얘가 구분해쥼 --%>
					<form:errors path="id" class="error" delimiter="<br>"/>
					<%-- JavaScript 에러메세지 출력을 위해 선언 --%>
					<span id="idMsg" class="error"></span>
				</td>
			</tr>	
			<tr>
				<td>비밀번호</td>
				<td>
					<%--password(Spring)태그 : 텍스트를 입력받기 위한 태그 - HTML의 input태그(type 속성값 : text) --%>
					<form:password path="pw"/>
				</td>
				<td>
					<form:errors path="pw" class="error" />
					<span id="pwMsg" class="error"></span>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="name"/>
				</td>
				<td>
					<form:errors path="name" class="error"/>
					<span id="nameMsg" class="error"></span>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<form:input path="email"/>
				</td>
				<td>
					<form:errors path="email" class="error"/>
					<span id="emailMsg" class="error"></span>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<%-- radiobutton(Spring) 태그 : 목록 중 하나만 선택하여 입력하는 태그 - HTML의 input 태그(type 속성값 : radio)
													 => path속성 대신 id또는 name 또는 value 속성 사용 가능
												     => Spring에서 제공되는 태그는 반드시 속성과 속성값이 반드시 하나의 쌍으로 표현 - 생략될 경우 500에러 발생
														ex) checked --%>
					<%-- 
					남자<form:radiobutton path="gender" id="gender1" value="남자" checked="checked" />
					&nbsp;&nbsp;
					여자<form:radiobutton path="gender" id="gender2" value="여자"/>
					--%>
					<%-- radiobuttons(Spring) 태그 : 목록 중 하나만 선택하여 입력하는 태그 - HTML의 input 태그 
													 items속성 : view페이지에 제공되는 List객체를 속성값으로 설정
													 			 => List객체의 요소가 선택목록으로 설정
													 			 => 기본값 설정이 불가능하므로 JavaScript를 이용하여 설정 --%>
					
					<form:radiobuttons path="gender" items="${genderList }" />
					
					<%-- List 형태로 출력 --%>
					<%-- <form:select path="gender" items="${genderList }"></form:select> --%>
				</td>
				<td>
					<form:errors path="gender" class="error"/>
					<span id="genderMsg" class="error"></span>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<button type="submit">회원등록</button>
				</td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
	$("#gender2").prop("checked", true);
	
	$("#form").submit(function() {
		$(".error").text("");
		/*
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
		*/
	});	
	</script>

</body>
</html>















