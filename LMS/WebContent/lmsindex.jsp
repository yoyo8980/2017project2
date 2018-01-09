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
		z-index: 0 ;
	}
	#lmsweb{
		position: relative;
		float: right ;
		width: 30% ;
		z-index: 0 ;
	}
	#login{
		margin-left:0px;
		margin-top:0px;
		height: 0px;
		width: 0px;
	}
	.all a{
		margin-left:100px;
	}
@MEDIA screen and (max-width: 767px) {
	#mktweb{
		display: none;
	}
	#lmsweb{
		float: left;
		width: 90%;
		height: 500px;
		overflow: scroll;
	}
	.all a{
		margin-left:0px;
	}
	div.lmsnavi{
	margin-left: 0px;
	margin-top: 25px ;
	}
}	
</style>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<p>${sessionScope.powerName } 님 환영합니다.</p>
<p>${sessionScope.power } 팀</p>
<h2>현재 운영중 강좌</h2>
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
	<h2>LMS 메뉴</h2>
	<c:set var="power" value="${sessionScope.power }"></c:set>
	<c:if test="${power eq 'master' or power eq 'mgr' }">
			<div>
			    <a href="openlec.do">강좌 개설</a>
			</div>
	</c:if>
	<c:if test="${power eq 'master' or power eq 'mgr' or power eq 'teach'}">		
			<div>
				<a href="roll.do?root=""">출결 관리</a>
			</div>
	</c:if>
	<c:if test="${power eq 'master' or power eq 'mgr' or power eq 'teach'}">		
			<div>
				<a href="score.do?root="" ">성적 관리</a>
			</div>
	</c:if>
	<c:if test="${power eq 'master' or power eq 'mgr' }">		
			<div>
				<a href="stu.do">학생 관리</a>
			</div>
	</c:if>
	<c:if test="${power eq 'master' or power eq 'mgr' or power eq 'sales'}">		
			<div>
				<a href="candi.do">후보생 관리</a>
			</div>
	</c:if>		
			<div>
				<a href="qanda.do">QnA 관리</a>
			</div>
	<c:if test="${power eq 'master' or power eq 'mgr' or power eq 'sales'}">		
			<div>
				<a href="board01.do">상담 게시판</a>
			</div>
	</c:if>
	<c:if test="${power eq 'master' or power eq 'hrm'}">		
		    <div>
				<a href="hrmgr.do?root=""">계정 관리</a>
			</div>
	</c:if>		
	<%-- <c:choose>
		<c:when test="${power eq 'mgr' or power eq 'acc'}">
			<div>
			    <a href="openlec.do">*강좌 개설</a>
			</div>
			<div>
				<a href="roll.do?root=""">*출결 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'teach'}">
			<div>
				<a href="roll.do?root="" ">*출결 관리</a>
			</div>
			<div>
				<a href="score.do?root="" ">*성적 관리</a>
			</div>
			<div>
				<a href="stu.do">*학생 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'sales'}">
			<div>
				<a href="candi.do">*후보생 관리</a>
			</div>
			<div>
				<a href="qanda.do">*QnA 관리</a>
			</div>
		</c:when>
		<c:when test="${power eq 'acc'}">
			<div>
				<a href="board01.do">*상담 게시판</a>
			</div>
		    <div>
				<a href="hrmgr.do?root=""">*계정 관리</a>
			</div>
		</c:when>
				
				
				
		<c:when test="${power eq 'master'}">			
			<div>
			    <a href="openlec.do">*강좌 개설</a>
			</div>
			<div>
				<a href="roll.do?root=""">*출결 관리</a>
			</div>
			<div>
				<a href="score.do?root="" ">*성적 관리</a>
			</div>
			<div>
				<a href="stu.do">*학생 관리</a>
			</div>

			<div>
				<a href="candi.do">*후보생 관리</a>
			</div>
			<div>
				<a href="qanda.do">*QnA 관리</a>
			</div>
			<div>
				<a href="board01.do">*상담 게시판</a>
			</div>
		    <div>
				<a href="hrmgr.do?root=""">*계정 관리</a>
			</div>
		</c:when>
	</c:choose> --%>
</div>
<script>
document.getElementById("logo").style.visiblity="hidden";
</script>	
</body>
</html>