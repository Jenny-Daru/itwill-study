<%--<%@page import="site.itwill.dto.UserinfoDTO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 회원정보를 입력받기 위한 JSP문서 --%>
<%-- [회원등록]을 클릭한 경우 회원정보 저장 처리페이지(/userinfo/join) 요청 --%>
<%-- [로그인]을 클릭한 경우 로그인정보 입력페이지(/userinfo/login) 요청 --%>
<%-- 
<%

	//가장 중요한 작업 보안 ♥ 시큐얼코딩 ♥
	/* WritefromModel이 했기 때문에 안해도됨 
 	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	*/

	//저장된 객체 Object타입이므로 형변환시킴 
	//session이 아니고 request 로 가져오기
	String message=(String)request.getAttribute("message");
	if(message==null) {
		message="";
	} 
	
	UserinfoDTO userinfo=(UserinfoDTO)session.getAttribute("userinfo");
	if(userinfo==null) {
		userinfo=new UserinfoDTO();
		userinfo.setUserid("");
		userinfo.setPassword("");
		userinfo.setName("");
		userinfo.setEmail("");
	} else {
		//저장된 값이 있다면 제거 
		session.removeAttribute("userinfo");
	}
	
	
%>
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel=stylesheet href="<%=request.getContextPath()%>/model_two/css/user.css" type="text/css"> --%>
<link rel=stylesheet href="${pageContext.request.contextPath }/css/user.css" type="text/css">
<script language="JavaScript">
function userCreate() {
	if ( f.userid.value == "" ) {
		alert("아이디를 입력하십시요.");
		f.userid.focus();
		return;
	} 
	if ( f.password.value == "" ) {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return;
	}
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return;
	}
	
	f.action = "${pageContext.request.contextPath }/userinfo/join";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td style="color: red;">${message }</td>			
	</tr>

	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원등록</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <form name="f" method="post">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<%--<input type="text" style="width:150" name="userid" value="<%=userinfo.getUserid()%>"> --%>
				<input type="text" style="width:150" name="userid" value="${userinfo.userid }">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="password" style="width:150" name="password" value="${userinfo.password }">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="text" style="width:240" name="name" value="${userinfo.name }">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="text" style="width:240" name="email" value="${userinfo.email }">
			</td>
		  </tr>		  
	  </table>
	  </form>
	  <br>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
				<input type="button" value="회원등록" onClick="userCreate();">
				<input type="button" value="로그인" onClick="location.href='${pageContext.request.contextPath }/userinfo/login';">
			</td>
		  </tr>
	  </table>
	  </td>
	</tr>
</table>  
</body>
</html>