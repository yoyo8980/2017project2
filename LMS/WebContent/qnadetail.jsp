<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
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
<h2>QnA 상세</h2>
<h3>질문</h3>
<table >
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>내용</th>
		<th>이메일</th>
		<th>전화</th>
	</tr>
	<tr>
	<c:forEach items="${qdetail }" var="bean">
		<td>${bean.qnaid }</td>
		<td>${bean.author }</td>
		<td>${bean.content }</td>
		<td>${bean.email }</td>
		<td>${bean.phonenum }</td>
	</c:forEach>	
	</tr>	
</table>
<c:forEach items="${adetail }" var="bean">
	<div>댓글: ${bean.content }</div>
	<div>by: ${bean.author }</div>
</c:forEach>
<form action="reply.do">
		<div>
		<label for="intro">댓글 추가</label><br>
		<textarea name="reply" id="reply" rows=5 cols=30></textarea>
	</div>
</form>
<p><a href="qanda.do">QnA목록으로</a></p>
<p><a href="lmsindex.do">메인으로</a></p>
</div>
</body>
</html>