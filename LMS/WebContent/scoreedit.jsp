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
	<h1>점수페이지</h1>
		<table border="1">
		        <tr>
		         <!--  <th>점수아이디</th>
		          
		          <th>학생아이디</th> -->
		          <th>학생</th>
		          <th>과목</th> 
		          <th>점수</th>
		         <!-- <th>교실</th>
		           -->
		        </tr>
		        
	     <c:forEach items="${slist }" var="sbean">   
	        <tr>
	         <!--  <td>${sbean.scoreid }</td>
	          
	          <td>${sbean.stuid }</td> -->
	          <td><a href="scoredetail.do?idx=${sbean.scoreid }">${sbean.stuname }</a></td>
	          <td>${sbean.subject }</td>
	           <td>${sbean.score }</td>
	          <!--  <td>${sbean.sclass }</td>
	          <td><input type="text" name="score" id="score" value=${sbean.score }></td>
	        </tr> -->
	 	 </c:forEach> 
		</table>
</body>
</html>