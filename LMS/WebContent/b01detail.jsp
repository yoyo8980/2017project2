<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 상담 상세</title>
</head>
<body>
<h2>이메일 상담 목록</h2>
	<table border=1>
		 <tr>
		   <th>번호</th>
		   <th>작성자</th>
		   <th>이메일</th>
		   <th>전화번호</th>
		   <th>제목</th>
		   <th>내용</th>
		 </tr>
		 <c:forEach items="${list }" var="bean">
		 <tr>
		   <td>${bean.emailId }</td>
		   <td>${bean.author }</td>
		   <td>${bean.email }</td>
		   <td>${bean.phonenum }</td>
		   <td>${bean.title }</td>
		   <td>${bean.content }</td>
		 </c:forEach>
	</table>
	<a href="board01.do">목록으로</a><br>
	<a href="lmsindex.do">메인으로</a>
</body>
</html>