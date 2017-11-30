<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>과거학생상세페이지</h1>
<form action="stugudetail.do?sId=${bean.sId }">

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
<a href="stucom.do">[조회하기로]</a>
<a href="stu.do">[목록으로]</a>
</body>
</html>