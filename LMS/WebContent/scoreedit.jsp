<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적 수정</title>
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
<script src="js/mktwebside.js"></script>
</head>
<body>

<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a><a href="score.do?root="""> /성적 관리 </a> /성적 수정 </div>
<h3>성적 수정</h3>
	<form action="scoresedit.do" method="post">	
		<table>
			<tr>
				<th>과목</th>
				<th>이름</th>
				<th>점수입력</th>
			</tr>
			<c:forEach items="${list}" var="bean">
				<tr>
					<td>${bean.subject }</td>
					<td>${bean.stuname }</td>
					<td>
						<input type="text" value="${bean.score }" name="${bean.scoreid }" required/>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach items="${list}" var="bean" begin="0" end="0">
			<div>
				<input type="hidden" value="${bean.stuid }" name="stuid"/>
				<input type="hidden" value="${bean.stuname }" name="stuname"/>
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