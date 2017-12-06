<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 상담 상세</title>
<script src="js/mktwebside.js"></script>
</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="board01.do">이메일목록</a></div>
<p>이메일 상세보기</p>
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
	<a href="lmsindex.do">메인으로</a>
</div>	
</body>
</html>