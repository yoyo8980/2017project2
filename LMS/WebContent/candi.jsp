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
</style>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="candi.do">후보생관리</a></div>
<c:set var="power" value="${sessionScope.power }"></c:set>
<c:choose>
	<c:when test="${power eq 'master' or power eq 'mgr' or power eq 'sales'}">
	<h2>후보생관리</h2>
	<h3><a href="candiview.do">후보생조회</a></h3>
	<h3><a href="candiadd.do">후보생추가</a></h3>
	</c:when>
	<c:otherwise>
	<div><h3>접근 권한이 없습니다.</h3>
	</div>
	</c:otherwise>
</c:choose>	
</div>	
</body>
</html>