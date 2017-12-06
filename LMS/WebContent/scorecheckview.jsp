<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>check view page</h1>
	<form action="scorechecked.do" method="post">	
		<div>
			<label for="stuname">이름</label>
			<input type="text" name="stuname">
		</div>
		<div>
			<label for="stuid">ID</label>
			<input type="text" name="stuid">
		</div>
		<div>
			<button type="submit">조회</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>