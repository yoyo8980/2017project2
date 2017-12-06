<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb"  class="all">
	<form action="hrmgredit.do" method="post">
		<c:forEach items="${list }" var="bean">
			<div>
				<label for="hrid">ID</label>
				<input type="text" name="hrid" value="${bean.hrid }" readonly="readonly"/>
			</div>
			<div>
				<label for="hrname">이름</label>
				<input type="text" name="hrname" value="${bean.hrname }"/>
			</div>
			<div>
				<label for="team">부서</label>
				<input type="text" name="team" value="${bean.team }"/>
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