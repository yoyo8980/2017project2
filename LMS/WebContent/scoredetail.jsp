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
<style>
	#scoreid{
	display: none;
	}
</style>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
<h2>detail page</h2>
<form action="edit.do" method="post">
	<table>
		<tr>
	          <th>점수아이디</th>
	          <th>과목</th>
	          <th>학생아이디</th>
	          <th>학생</th>
	          <th>교실</th>
	          <th>점수</th>
	    </tr>
	    
	    <c:forEach items="${list }" var="bean">   
        <tr>
          <td><input id="scoreid" name="scoreid" value="${bean.scoreid }"></td>
          <td>${bean.subject }</td>
          <td>${bean.stuid }</td>
          <td>${bean.stuname }</td>
          <td>${bean.sclass }</td>
          <td><input type="text" id="score" name="score" value=${bean.score }></td>
        </tr>
 	 </c:forEach> 
	</table>
	<div>
 <button>수정</button>
	</div>

 </form>
 </div>
</body>
</html>