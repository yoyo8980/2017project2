<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
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
</style>
<script src="js/mktwebside.js"></script>
<script type="text/javascript">
window.addEventListener("load", function(){
	var snameVal = document.getElementById("sname");
	var sidVal = document.getElementById("sid");
	var spans = document.querySelectorAll('span'); 
	
	snameVal.onkeydown= function(){
		if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39
		  || event.keyCode == 46 ) return;
		snameVal.value = snameVal.value.replace(/[\A-Z a-z 0-9]/,'', /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\']/g);
	};
	
	sidVal.onkeydown= function(){
		if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39
		  || event.keyCode == 46 ) return;
		sidVal.value = sidVal.value.replace(/[\A-Z a-z ㄱ-ㅎㅏ-ㅣ가-힣-]/g,'');
		
	};
	snameVal.addEventListener("change",function(){
		 spans[0].innerText='';
	        if(snameVal.value.length<8){
				spans[0].innerText='8자이상 작성';
				snameVal.value="";
			}
		});	
	sidVal.addEventListener("change",function(){
		 spans[1].innerText='';
	        if(sidVal.value.length!=4){
				spans[1].innerText='ID는 4자입니다';
				sidVal.value="";
			}
		});	
});
</script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a><a href="roll.do?root="""> /출결 관리 </a> /출석부 수정 </div>
	<h3>출석부 수정</h3>
	<form action="roll.do" method="get">
		<div>
			<label for="sname">이름</label>
			<input type="text" name="sname" id="sname" style="ime-mode:disabled;" required/>
		</div>
		<div>
			<span></span>
		</div>
		<div>
			<label for="sid">ID</label>
			<input type="text" name="sid" id="sid" required/>
		</div>
		<div>
			<span></span>
		</div>
		<div>
			<input type="hidden" value="edit" name="root"/>
		</div>
		<div>
			<button type="submit">조회</button>
			<button type="reset">취소</button>
		</div>
	</form>
</div>
</body>
</html>