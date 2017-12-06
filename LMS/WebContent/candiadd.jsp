<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후보생 추가 페이지</title>
<script src="js/mktwebside.js"></script>

</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/<a href="candiadd.do">후보생추가</a></div>
<h2>후보생추가페이지</h2>

<form action="candiadd.do" method="post">

<div>
	<label for="sid">아이디</label>
	<c:forEach items="${bean }" var="bean2" begin="0" end="0">
	<input type="text" name="sId" value="${bean2.sId }" readonly="readonly"/>
	</c:forEach>
</div>
<div>
	<label for="sname">이름</label>
	<input type="text" name="sName"/>
</div>
<div>
	<label for="birth">생일</label>
	<input type="date" name="birth" />
</div>
<div>
	<label for="phone">전화번호</label>
	<input type="phone" name="phone" />
</div>
<div>
	<label for="email">이메일</label>
	<input type="email" name="email" />
</div>
<div>
	상태 <select name="status">
	<option>선택하세요</option>
	<c:forEach items="${bean }" var="bean2">
		<option value="${bean2.status }">${bean2.status }</option>
	</c:forEach>
	<!-- <option>상담중</option>
	<option>수강대기</option>
	<option>수강예정</option> -->
	</select>
</div>
<div>
	<label for="regclass">반</label>
	<input type="number" name="regclass" value="9999" readonly="readonly"/>
</div>
	<button type="submit">입력</button>
</form>
</div>
</body>
</html>