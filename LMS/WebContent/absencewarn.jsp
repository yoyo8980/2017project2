<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
<style type="text/css">
	#mktweb{
		position: absolute;
		width: 100%;
		z-index: 0 ;
	}
	#lmsweb{
		position: relative;
		float: right ;
		width: 30% ;
		z-index: 0 ;
	}
	#login{
		margin-left:0px;
		margin-top:0px;
		height: 0px;
		width: 0px;
	}
</style>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>&nbsp/&nbsp<a href="roll.do?root=""">출결관리</a>&nbsp/&nbsp결석자</div>
<h2>1. 최근(지난24시간) 결석/지각/조퇴자</h2>
	<table>
		<tr>
			<th>학번</th>
			<th>출결</th>
		</tr>
		<c:forEach items="${recent }" var="recentWarn">
		<tr>
		 	<td>${recentWarn.key }</td>
		 	<td>${recentWarn.value }</td>
		</tr>
		</c:forEach>	
	</table>
<h2>2. 학번별 결석 누계</h2>
	<table>
		<tr>
			<th>학번</th>
			<th>출결요약</th>
		</tr>
		<c:forEach items="${summary }" var="rollWarn">
		<tr>
		 	<td class="studetail">${rollWarn.key }</td>
		 	<td>${rollWarn.value }</td>
		</tr>
		</c:forEach>	
	</table>
</div>	
</body>
</html>