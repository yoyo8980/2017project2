<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	<div>
		<form method="post">
			<table>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>부서</th>
				</tr>			
				<c:forEach items="${list }" var="bean">	
				<tr>					
					<td><a href="hrmgr.do?root=edit&hrid=${bean.hrid }">${bean.hrid }</a></td>
					<td>${bean.hrname }</td>
					<td>${bean.team }</td>					
				</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>