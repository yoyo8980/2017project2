<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후보생 수정페이지</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>

</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="candiedit.do">후보생수정</a></div>
<h2>후보생 수정페이지</h2>
<form action="candiedit.do" method="post">
<%-- 	<c:forEach items="${bean }" var="bean"> --%>
	
		<div>
			<label>아이디</label>
			<input type="text" name="sId" value="${bean.sId }" readonly="readonly"/>
		</div>
		<div>
			<label>이름</label>
			<input type="text" name="sName" value="${bean.sName }"/>
		</div>
		<div>
			<label>생일</label>
			<input type="date" name="birth" value="${bean.birth }"/>
		</div>		
		<div>
			<label>전화번호</label>
			<input type="phone" name="phone" value="${bean.phone }"/>
		</div>
		<div>
			<label>이메일</label>
			<input type="email" name="email" value="${bean.email }"/>
		</div>
		<div>
			<label>반</label>
			<input type="number" name="regclass" value="${bean.regclass }"/>
		</div>		
		<div>
			<label>상태</label>
			<select name="status">
				<option >선택하세요</option>
				<option value="상담중">상담중</option>
				<option value="수강대기">수강대기</option>
				<option value="수강예정">수강예정</option>
			</select>
		</div>		

			<%-- <td><input type="text" name="status" value="${bean.status }"/></td> --%>
		
	<%-- </c:forEach> --%>
	<div><button type="submit">완료</button></div>
</form>
</div>
</body>
</html>