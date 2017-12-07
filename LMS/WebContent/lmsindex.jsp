<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>

<script src="js/mktwebside.js"></script>
<style type="text/css">
	#mktweb{
		position: absolute;
		width: 100%;
		z-index: -3;
	}
	
</style>
</head>
<body>
<div id="mktweb" ><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
<h2>어서오세요</h2>
	<table>
	<div>
        <tr>
          <th>강의ID</th>
          <th>강좌명</th>
          <th>수강생</th>
        </tr>
	</div>
    
	<div>
     <c:forEach items="${statuslist }" var="bean">   
        <tr>
          <td>${bean.lecId }</td>
          <td>${bean.lecName }</td>
          <td>${bean.sid }</td>
        </tr>
 	 </c:forEach>
    
	</div>     
        
	</table>
	<br/>
	
	<div class="menu">
	<c:set var="power" value="${sessionScope.power }"></c:set>
	<c:choose>
		<c:when test="${power eq 'mgr'}">
			<div>
			    <a href="openlec.do">강좌 개설</a>
			</div>
			<div>
				<a href="roll.do?root=""">출결 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'teach'}">
			<div>
				<a href="score.do?root="" ">성적 관리</a>
			</div>
			<div>
				<a href="stu.do">학생 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'sales'}">
			<div>
				<a href="candi.do">후보생 관리</a>
			</div>
			<div>
				<a href="qanda.do">*QnA 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'acc'}">
			<div>
				<a href="board01.do">상담 게시판</a>
			</div>
		    <div>
				<a href="hrmgr.do?root=""">계정 관리</a>
			</div>
		</c:when>
				
				
				
		<c:when test="${power eq 'master'}">			
			<div>
			    <a href="openlec.do">강좌 개설</a>
			</div>
			<div>
				<a href="roll.do?root=""">출결 관리</a>
			</div>
			<div>
				<a href="score.do?root="" ">성적 관리</a>
			</div>
			<div>
				<a href="stu.do">학생 관리</a>
			</div>

			<div>
				<a href="candi.do">후보생 관리</a>
			</div>
			<div>
				<a href="qanda.do">QnA 관리</a>
			</div>
			<div>
				<a href="board01.do">상담 게시판</a>
			</div>
		    <div>
				<a href="hrmgr.do?root=""">계정 관리</a>
			</div>
		</c:when>
	</c:choose>
	<p>${sessionScope.teachName }</p>
	<p>${sessionScope.lecid }</p>
	</div>
</div>	
</body>
</html>