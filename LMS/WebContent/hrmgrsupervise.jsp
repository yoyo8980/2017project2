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
	.all label{
		width: 100px;
	}
</style>
<script src="js/mktwebside.js"></script>
<script type="text/javascript">
	window.addEventListener("load", function(){
		var webidVal = document.getElementById("id");
		var webpwVal = document.getElementById("pw");
		var webrePwVal = document.getElementById("rePw");
		var spans=document.querySelectorAll('span');
		webidVal.onkeydown = function(){	
			 //좌우 방향키, 백스페이스, 딜리트, 탭키에 대한 예외
	        if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39
	        || event.keyCode == 46 ) return;
	        webidVal.value = webidVal.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣-]/g, '');       
		};
		webidVal.addEventListener("change",function(){
		 spans[0].innerText='';
	        if(webidVal.value.length<8){
				spans[0].innerText='8자이상 작성';
				webidVal.value="";
			}
		});		
		webpwVal.addEventListener("change", function(){		
	        spans[1].innerText='';   
			if(webpwVal.value.length<8){
				spans[1].innerText='8자이상 작성';
				webpwVal.value="";
			}
		});
		webrePwVal.addEventListener("change", function(){		
	        spans[1].innerText='';    
			if(webrePwVal.value.length<8){
				spans[2].innerText='8자이상 작성';
				webrePwVal.value="";
			}
			if(webpwVal.value!=webrePwVal.value){
				spans[2].innerText='비밀번호 불일치';
				webrePwVal.value="";
			}
			if(webpwVal.value==webrePwVal.value){
				spans[2].innerText='비밀번호 일치';
			}
		});
	});

</script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a><a href="hrmgr.do?root="""> /계정 관리 </a> /로그인ID&PW관리 </div>
	
	<h2>로그인ID&PW관리</h2>
		<form action="hrmgrsup.do" method="post">
		<div>
			<label>이름</label>
  			<select name="hrid" required>
    	  			<option>선택하세요</option>
    	  			<c:forEach items="${list }" var="bean">   	  		
          				<option value="${bean.hrid}">${bean.hrid} (${bean.hrname})</option>
         			 </c:forEach>
        		</select>
		</div>
			
			<div>
				<label for="id">WebID입력</label>
				<input type="text" name="id" value="${bean.webid }" id="id"  style="ime-mode:disabled;" required/>
			</div>
			<div>
				<span></span>
			</div>
			<div>
				<label for="pw">WebPW입력</label>
				<input type="password" name="pw" id="pw" required/>
			</div>
			<div>
				<span></span>
			</div>
			<div>
				<label for="rePw">PW재입력</label>
				<input type="password" name="rePw" id="rePw" required/>
			</div>
			<div>
				<span></span>
			</div>
			
			<div>
				<button type="submit">완료</button>
				<button type="reset">취소</button>
			</div>
		
		</form>
	</div>

</body>
</html>