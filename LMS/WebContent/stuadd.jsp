<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생추가페이지</h1>

<form action="stuadd.do" method="post">

<div>
	<label for="sid">아이디</label>
	<input type="text" name="sId" />
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
	<label for="regclass">반</label>
	<input type="number" name="regclass" />
</div>
	<button onclick="location.href='http://localhost:8080/LMS/stuview.do'">입력</button>
</form>
</body>
</html>