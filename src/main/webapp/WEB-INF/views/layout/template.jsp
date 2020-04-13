<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- tiles 관련 태그를 제공하는 태그 라이브러리 포함 --%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css">
<style type="text/css">
#header {
	border: 2px solid red;
	height: 100px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}

#content {
	border: 2px solid green;
	min-height: 300px;
	margin: 10px;
	padding: 10px;
}

#footer {
	border: 2px solid blue;
	min-height: 100px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}

</style>
</head>
<body>
	<%-- 여기에 header와 footer를 작성하면 된다 --%>
	<div id="header">
		<%-- insertAttribute : Attribute를 삽입하려면 Attribute가 있어야 한다 => tiles.xml 고고 --%>
		<%-- insertAttribute : put-Attribute 엘리먼트에서 설정된 JSP 문서의 결과를 삽입하는 태그 
							    name속성 : put-Attribute 엘리먼트의 고유값을 속성값으로 설정  --%>
		<tiles:insertAttribute name="header"/>
	</div>
	
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>





