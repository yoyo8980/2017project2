<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="candi.do">후보생관리</a>/<a href="candiview.do">후보생 조회</a></div>
<h2>후보생조회</h2>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>상태</th>
			</tr>
		
		<c:forEach items="${list }" var="bean">
			<tr>
				<td><a href="candidetail.do?sId=${bean.sId }">${bean.sId }</a></td>
				<td>${bean.sName }</td>
				<td>${bean.birth }</td>
				<td>${bean.status }</td>
			</tr>
		</c:forEach>
		</table>
	
</div>
</body>
</html>