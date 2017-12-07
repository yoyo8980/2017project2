<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생상세페이지</title>
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
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/학생상세조회</div>
<h2>학생상세페이지</h2>
<form action="studetail.do?sId=${bean.sId }">

	<table>
		<tr>
			<th>아이디</th>
			<td>${bean.sId }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${bean.sName }</td>
		</tr>
		<tr>
			<th>생일</th>
			<td>${bean.birth }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${bean.phone }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${bean.email }</td>
		</tr>
		<tr>
			<th>반</th>
			<td>${bean.regclass }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${bean.status }</td>
		</tr>
	</table>
</form>
<span>
<a href="stuedit.do?sId=${bean.sId }">[수정]</a>
<a href="studelete.do?sId=${bean.sId }">[삭제]</a>
<a href="stuview.do">[목록]</a>
</span>
</div>
</body>
</html>