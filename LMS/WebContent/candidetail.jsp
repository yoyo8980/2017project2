<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후보생 상세 페이지</title>
</head>
<body>
<h1>후보생 상세페이지</h1>
<form action="candidetail.do?sId=${bean.sId }">

	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${bean.sId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${bean.sName }</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${bean.birth }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${bean.phone }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${bean.email }</td>
		</tr>
		<tr>
			<td>반</td>
			<td>${bean.regclass }</td>
		</tr>
		<tr>
			<td>상태</td>
			<td>${bean.status }</td>
		</tr>
	</table>
</form>
<a href="candiedit.do?sId=${bean.sId }">[수정]</a>
<a href="candidelete.do?sId=${bean.sId }">[삭제]</a>
<a href="candiview.do">[목록]</a>
<a href="candiview.do">[입학]</a><!-- 입학누르면 테이블에서 삭제되고, stu테이블로 들어가짐. -->
</body>
</html>