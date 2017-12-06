<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
<form action="lmsindex.do" method="post">
    <div>
        <label for="webid">WEBID</label>
        <input type="text" name="webid"/>
    </div>
    <div>
        <label for="webpw">WEBPW</label>
        <input type="text" name="webpw"/>
    </div>
    <div>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>