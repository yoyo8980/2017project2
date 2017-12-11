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
	.all button{
		margin-left: 80px;
	}
</style>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="stu.do">학생관리</a>/<a href="stuadd.do">학생추가</a></div>
<h2>학생추가</h2>


<form action="stuadd.do" method="post">

<div>
	<label for="sid">아이디</label>
	<c:forEach items="${bean }" var="bean2" begin="0" end="0">
		<input type="text" name="sId" value="${bean2.sId }" readonly="readonly"/>
	</c:forEach>
</div>
<div>
	<label for="sname">이름</label>
	<input type="text" name="sName" required/>
</div>
<div>
	<label for="birth">생일</label>
	<input type="date" name="birth" required/>
</div>
<div>
	<label for="phone">전화번호</label>
	<input type="phone" name="phone" required/>
</div>
<div>
	<label for="email">이메일</label>
	<input type="email" name="email" required/>
</div>
<div>
	 <label>반</label>
	 <select name="regclass">
		<option>수업중인 반</option>
		<c:forEach items="${bean2 }" var="bean3">
			<option value="${bean3 }">${bean3 }</option> 
		</c:forEach> 	
	</select>
</div>
<div>
	<button type="submit">입력</button>
</div>
</form>
</div>

</body>
</html>