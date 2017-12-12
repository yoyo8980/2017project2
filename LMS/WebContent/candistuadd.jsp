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
	#addtb{
		margin: 10px;
	}
	#addtb div{
		margin-bottom: 5px;
	}
	#addtb label{
		width: 65px;
		display:inline-block;
		background-color: darkblue;
		color:white;
		text-align: center;
	}
	#addtb button{
		margin-left: 100px;
		margin-top: 20px;
		text-align: center;
	}
	#addtb button:hover{
		background-color: darkblue;
		color:white;
		outline: 0;
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
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="stuadd.do">학생추가</a></div>
<h2>학생추가</h2>

<div id="addtb">
<form action="candistudeladd.do" method="post">
<div>
	<label for="sid">아이디</label>
	<c:forEach items="${list }" var="bean" begin="0" end="0">
		<input type="text" name="sId" value="${bean.sId }" readonly="readonly"/>
	</c:forEach>
</div>
<div>
	<label for="sname">이름</label>
	<input type="text" name="sName" value="${sName}" readonly="readonly"/>
</div>
<div>
	<label for="birth">생일</label>
	<input type="text" name="birth" value="${birth }" readonly="readonly"/>
</div>
<div>
	<label for="phone">전화번호</label>
	<input type="phone" name="phone" value="${phone }" readonly="readonly"/>
</div>
<div>
	<label for="email">이메일</label>
	<input type="email" name="email" value="${email }" readonly="readonly"/>
</div>

<div>
	 <label>반</label>
	 <select name="regclass" required>
		<option>수업중인 반</option>
		<c:forEach items="${list}" var="bean2" begin="1" end="${list.size() }">
			<option value="${bean2.regclass}">${bean2.regclass}</option> 
		</c:forEach> 	
	</select>
</div>
	<input type="hidden" value="${candiId }" name="candiId">
	<button type="submit">입력</button>
</form>
</div>
</div>
</body>
</html>