<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>
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
<script src="js/mktwebside.js"></script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a><a href="roll.do?root="""> /출결 관리 </a> /출석부 수정 </div>
	<h3>출석부 수정</h3>
	<form action="rollsedit.do" method="post">	
		<table>
			<tr>
				<th>날짜</th>
				<th>ID</th>
				<th>이름</th>
				<th>출석</th>
			</tr>
			<c:forEach items="${list}" var="bean">
				<tr>
					<td>${bean.calldate }</td>
					<td>${bean.stuid }</td>
					<td>${bean.stuname }</td>
					<td>
						<select name="${bean.rollid }">
							<option value="${bean.status }" selected="selected">(현재)${bean.status }</option>
							<option value="출석" >출석</option>
							<option value="결석">결석</option>
							<option value="지각" >지각</option>
							<option value="조퇴">조퇴</option>											
						</select>
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach items="${list}" var="bean" begin="0" end="0">
			<div>
				<input type="hidden" value="${bean.stuid }" name="sid"/>
				<input type="hidden" value="${bean.stuname }" name="sname"/>
			</div>
		</c:forEach>
		<div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</div>
		
		</form>
</div>
</body>
</html>