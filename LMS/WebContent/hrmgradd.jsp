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
	<h2>입력페이지</h2>
	
	
		<form action="hrmgrinsert.do" method="post">
			<div>
				<label>ID</label>
				<input type="text" name="webid"/>
			</div>
			<div>
				<label>PW</label>
				<input type="text" name="webpw"/>			
			</div>
			<div>
				<label>NUM</label>
				<c:forEach items="${list }" var="bean" begin="6" end="6">
						<input type="text" name="hrid" value="${bean.hrid }" readonly="readonly"/>
				</c:forEach>
			</div>
			<div>
				<label>NAME</label>
				<input type="text" name="hrname"/>
			</div>
			<div>
			<label>부서</label> 
		   	<select name="hrteam">
		    	  <option>선택하세요</option>
		    	  <c:forEach items="${list }" var="bean" begin="0" end="5">   	  		
		          		<option value="${bean.team}">${bean.team}</option>
		          </c:forEach>
		         </select>
         	</div>
	        <div class="view">               
				<button type="submit">입력</button>
				<button type="submit">취소</button>	
			</div>
		</form>
	
	</div>
</body>
</html>