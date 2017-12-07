<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과거학생조회페이지</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
<style type="text/css">
	#mktweb{
		position: absolute;
		width: 100%;
		z-index: -3;
	}
</style>
</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="stucom.do">과거학생조회</a></div>
<h2>과거학생조회</h2>
<form action="stugu.do" method="get">
	<p>조회할 학생 이름을 입력하세요</p>
	<div class="com">
	<input type="text" name="sName" >
	<button type="submit">조회</button>
	</div>
</form>
		<%-- <table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>c 
				<th>생일</th>
				<th>전화번호</th>
				<th>학생이메일</th>
				<th>반</th>
			</tr>
		
		<c:forEach items="${list2 }" var="bean">
			<tr>
				<td>${bean.sId }</td>
				<td>${bean.sName }</td>
				<td>${bean.birth }</td>
				<td>${bean.phone }</td>
				<td>${bean.email }</td>
				<td>${bean.regclass }</td>
			</tr>
		</c:forEach>
		</table>
	 --%>
</div>	
</body>
</html>