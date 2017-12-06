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
		<form action="hrmgrsup.do" method="post">
			<div>
			<label>이름</label>
  			<select name="hrid">
    	  			<option>선택하세요</option>
    	  			<c:forEach items="${list }" var="bean">   	  		
          				<option value="${bean.hrid}">${bean.hrid} (${bean.hrname})</option>
         			 </c:forEach>
        		</select>
			</div>
			<div>
				<label for="id">WebID</label>
				<input type="text" name="id" value="${bean.webid }"/>
			</div>
			<div>
				<label for="pw">WebPW</label>
				<input type="text" name="pw"/>
			</div>
			<div>
				<label for="rePw">PW 재입력</label>
				<input type="text" name="rePw"/>
			</div>
			<div class="view">
				<button type="submit">완료</button>
				<button type="reset">취소</button>
			</div>
		
		</form>
	</div>
	
</body>
</html>