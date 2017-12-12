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
input.submitLink {
    background-color: transparent;
    text-decoration: underline;
    border: none;
	font-size: 1em;
    cursor: pointer;
    }
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
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/후보생상세페이지</div>
<h2>후보생 상세페이지</h2>
<form action="candistuaddview.do" method="get">
	<table>
		<tr>
			<td>아이디</td>
			<td>${bean.sId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${bean.sName }</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${bean.birth }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${bean.phone }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${bean.email }</td>
		</tr>
		<tr>
			<td>반</td>
			<td>${bean.regclass }</td>
		</tr>
		<tr>
			<td>상태</td>
			<td>${bean.status }</td>
		</tr>
	</table>
	
<input type="hidden" value="${bean.sId }"name="candiId">
<input type="hidden" value="${bean.sName }"name="sName">
<input type="hidden" value="${bean.birth }"name="birth">
<input type="hidden" value="${bean.phone }"name="phone">
<input type="hidden" value="${bean.email }"name="email">
<div>
<a href="candiedit.do?sId=${bean.sId }">[수정]</a>
<a href="candidelete.do?sId=${bean.sId }">[삭제]</a>
<a href="candiview.do">[목록]</a>
<input type=submit value="[입학]" class="submitLink">
</div>
</form>
</div>
</body>
</html>