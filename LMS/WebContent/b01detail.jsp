<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 상담 상세</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="board01.do">이메일목록</a></div>
<h2>이메일 상세보기</h2>
	<table>
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
	<p><a href="lmsindex.do">메인으로</a></p>
</div>	
</body>
</html>