<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
</head>
<body>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
	<p><a class="a" href="roll.do?root=addview">[출석부 입력]</a></p>
	<p><a class="a" href="roll.do?root=editview">[출석부 수정]</a></p>
	<p><a class="a" href="roll.do?root=checkview">[출석부 조회]</a></p>
	</div>	
</body>
</body>
</html>