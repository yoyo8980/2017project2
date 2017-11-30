<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
<h2>과거학생조회목록</h2>
<form action="stugu.do">
	
	<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>상태</th>
			</tr>
		<c:forEach items="${bean }" var="bean2">
			<tr>
				<td><a href="stugudetail.do?sId=${bean2.sId }">${bean2.sId }</a></td>
				<td>${bean2.sName }</td>
				<td>${bean2.birth }</td>
				<td>${bean2.status }</td>
			</tr>
		</c:forEach>
		
		</table>
	</form>
	<a href="stucom.do">[뒤로]</a>
</body>
</html>