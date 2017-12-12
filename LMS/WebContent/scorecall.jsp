<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>
<style>
	.scoreRow{
		display: none;
	}
	#tableHeads{
		display:none;
		border-bottom: 1px solid gray;
	}
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
<script>
	window.addEventListener("load", function(){
		var lecSelect=document.getElementById("lecidSelect");
		var teacherLogin=document.querySelector("#teacherLogin");
		if(teacherLogin!=null){
			lecSelect.value = teacherLogin.value;
			lecSelect.disabled="true";
			var theads = document.getElementById("tableHeads");
			theads.style.display="block";
			
			var scoreRows =document.querySelectorAll(".scoreRow");
			
			for(var i=0; i<scoreRows.length; i++){
				if(lecidSelect.value==scoreRows[i].firstChild.nextSibling.innerHTML){
					scoreRows[i].style.display="block";
				}
			}	
		}
		
		lecSelect.addEventListener("change", function(){
			theads = document.getElementById("tableHeads");
			theads.style.display ="block";
			
			var scoreRows = document.querySelectorAll(".scoreRow");
			
			for(var i=0; i<scoreRows.length;i++){
				scoreRows[i].style.display ="none";
			}
			
			for(var i=0; i<scoreRows.length;i++){
				if(lecidSelect.value==scoreRows[i].firstChild.nextSibling.innerHTML){
					scoreRows[i].style.display="block";
				}
			}
		});
	});
</script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a>&nbsp/&nbsp<a href="score.do?root=""">성적 관리 </a> /성적 입력 </div>
<c:set var="power" value="${sessionScope.power }"></c:set>
<c:choose>
	<c:when test="${power eq 'teach' }">
		<c:set value="${sessionScope.powerName }" var="profile"></c:set>
		<p>${profile } 강사님 환영</p>
		<c:set value="${sessionScope.lecid }" var="chargedClass"></c:set>
		<input type="hidden"  id="teacherLogin" value="${chargedClass }"/>
	</c:when>
</c:choose>
<h3>성적 입력</h3>
<form action="scorecall.do" method="post">
<div>
	<label for="subject">과목선택:</label>
	<select id="subjectSelect" name="subjectChk">
		<option value="no">선택하세요</option>
		<option value="java">Java</option>
		<option value="web">Web</option>
		<option value="database">DataBase</option>
	</select>
</div>
<div>	
	<label for="lecid">분반선택:</label>
	<select id="lecidSelect" name="lecidChk">
		<option value="no">선택하세요</option>
		<c:forEach items="${lecidList}" var="bean">
			<option value="${bean }">${bean }</option>
		</c:forEach>
	</select>
</div>
	<table>
		<tr id="tableHeads">
			<th>분반</th>
			<th>학번</th>
			<th>이름</th>
			<th>성적</th>
		</tr>
		<c:forEach items="${score}" var="bean">
			<tr class="scoreRow">
				<td>${bean.sclass }</td>
				<td>${bean.stuid }</td>
				<td>${bean.stuname }</td>
				<td><input type="text" name="${bean.sclass }-${bean.stuid }-${bean.stuname }-" required/></td>
			</tr>			
		</c:forEach>
	</table>
	<div>
	<button type="submit">입력</button>
	<button type="reset">취소</button>
	</div>
	</div>
</form>
</body>
</html>