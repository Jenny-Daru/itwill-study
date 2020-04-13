<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<%-- 리소스 파일 : 소스가 되는 파일 -> 클라이언트가 사용하는 파일 -> 클라이언트에서 직접 접근하여 사용 가능(webapp도 불가)
					   멀티미디어 파일 - 이미지, 동영상, 음악
					   CSS 파일
					   JavaScript 파일 
					   ★중요★ 파일의 경로 설정 
					             => WEB-INF >> 하위 폴더에 있으면 절대 클라이언트가 접근 불가!!!
					             => webapp  >> 하위 폴더에 존재해야 접근 가능 >> 긍디 이것도 접근 안됨!!  
					             WEB-INF에 폴더를 하나 지정하여 자료를 다 여기다 넣고 다운로더를 통해 접근 가능하게 하는 방법도 존재함
					   ★문제★ 현재 클라이언트의 모든 요청을 Front Controller를 이용하여 처리
					             => 리소스 파일에 대한 요청을 Front Controller에게 요청할 경우 미응답(매핑 미처리)
					   ★해결★ 리소스 파일은 Front Controller를 이용하지 않고 요청 가능하도록 설정
					             => 직접요청을 받아 응답처리하면 됨~~~~ 심지어 이미되어있음~~~ 
					             => WHERE??? Bean Configuration File(servlet-context.xml)에서 resources 엘리먼트 사용 
					            * WAS실행될때 Bean Configuration File 을 읽어들이는데 전체Controller와 현재Controller 둘다 나뉨 
					               >> 거기서 현재Controller가 읽어들이는 컨트롤러(appServlet)의 xml파일 >> resources설정되어있지 *   --%>
					             
	<%-- Front controller가 모든 요청을 다 받는데 Front controller에는 처리하는 요청 메소드가 없다. => 리소스 파일을 요청한거지 프로그램이 아니니까 
	     리소스 파일은 프론트 컨트롤러가 요청을 받으면 안되~  --%>				      
	<h1>리소스 파일</h1>
	<hr />
	<%-- 즉!! 리소스 파일은 접근 불가야 --%> 
	<!-- <img src="resources/Tulips.jpg" width="200"/> -->
	<%-- 이거슨 상대경로 - 요청경로와 응답경로가 다르므로 문제점이 있을수 밖에 없지 
	      JSP가 views에 있으니 JSP를 기준으로 설정하면 노노노노놉 --%>
	<img src="images/Tulips.jpg" width="200"/>
	<img src="css/Chrysanthemum.jpg" width="200"/>
	
	
	<%-- [ 절댕경로 ] --%>
	<%-- 리소스 파일은 절대경로로 요청하는 것을 권장 --%>
	<%-- [방법1] --%>
	<img src="/spring/images/Tulips.jpg" width="200"/>
	
	<%-- [방법2]
		 컨텍스트 경로는 변경 가능하므로 메소드를 호출하여 제공받아 표현 권장
	      => 자바코드도 비권장 --%>
	<img src="<%=request.getContextPath() %>/css/Chrysanthemum.jpg" width="200"/>
	
	
	<%-- [방법3]
	     ★ EL내장객체와 Core태그 라이브러리 이용 권장 ★ 
		    컨텍스트 경로를 EL 내장객체를 이용하여 사용 --%>
	<img src="${pageContext.request.contextPath }/images/Tulips.jpg" width="200"/>

	<%-- [방법4]
	     Core 태그 라이브러리의 URL 태그를 이용하여 컨텍스트 경로를 포함하여 사용 --%>
	<img src='<c:url value="/css/Chrysanthemum.jpg"/>' width="200"/>
	
	<%-- [방법5]
	  	 Spring 태그 라이브러리의 URL 태그를 이용하여 컨텍스트 경로를 포함하여 사용 --%>
	<img src= <spring:url value="/images/Tulips.jpg"/> width="200"/>
</body>
</html>






















