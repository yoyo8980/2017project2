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
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
	<h2>수정페이지</h2>
	
		<form method="post">
			<table>
				<div>
					<tr>
						<th>ID</th>
						<th>이름</th>
						<th>부서</th>
					</tr>							
				</div>
				<div>				
						<select name="hrid">
						<c:forEach items="${list }" var="bean">
							<option value="${bean.hrid }">${bean.hrid }</option>					
						</c:forEach>
						</select>
				</div>								
				<div>
				<c:forEach items="${list }" var="bean">
					<tr>						
						<td>${bean.hrid }</td>
						<td>${bean.hrname }</td>
						<td>${bean.team }</td>					
					</tr>
				</c:forEach>
				</div>
				
			</table>
		</form>
	</div>
	
</body>
</html>