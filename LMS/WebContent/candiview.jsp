<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후보생조회페이지</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>

<style type="text/css">
	
</style>
</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="candiview.do">후보생 조회</a></div>
<h2>후보생조회</h2>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>상태</th>
			</tr>
		
		<c:forEach items="${list }" var="bean">
			<tr>
				<td><a href="candidetail.do?sId=${bean.sId }">${bean.sId }</a></td>
				<td>${bean.sName }</td>
				<td>${bean.birth }</td>
				<td>${bean.status }</td>
			</tr>
		</c:forEach>
		</table>
	<p><a href="candi.do">[목록]</a></p>
</div>
</body>
</html>