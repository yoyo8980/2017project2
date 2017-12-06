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
	<hi>roll edit page</hi>
	<form action="rollsedit.do" method="post">	
		<table>
			<tr>
				<th>날짜</th>
				<th>ID</th>
				<th>이름</th>
				<th>출석</th>
			</tr>
			<c:forEach items="${list}" var="bean">
				<tr>
					<td>${bean.calldate }</td>
					<td>${bean.stuid }</td>
					<td>${bean.stuname }</td>
					<td>
						<select name="${bean.rollid }">
							<option value="${bean.status }" selected="selected">(현재)${bean.status }</option>
							<option value="출석" >출석</option>
							<option value="결석">결석</option>
							<option value="지각" >지각</option>
							<option value="조퇴">조퇴</option>											
						</select>
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach items="${list}" var="bean" begin="0" end="0">
			<div>
				<input type="hidden" value="${bean.stuid }" name="sid"/>
				<input type="hidden" value="${bean.stuname }" name="sname"/>
			</div>
		</c:forEach>
		<div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</div>
		
		</form>
</body>
</html>