<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<style>
div{
	margin: auto;
	margin-top: 100px;
	width: 100%;
	height: 500px;
	background-image: url('bitcamplogo.jpg');
	background-repeat: repeat;
	opacity: 0.1;
}
p{
	background-color: white;
	position: absolute;
	top: 280px;
	left: 100px;
	font-size: 2em;
	opacity: 0.5;
}
</style>
</head>
<body>
<div></div>
<p>죄송합니다. 요청하신 페이지를 찾을 수 없습니다. 비트캠프 홈페이지로 이동합니다.</p>

<script type="text/javascript">
    function redirect() {
        location.href = "/LMS002/startweb.do";
    }
    window.setTimeout("redirect()", 3000);
</script>
</body>
</html>