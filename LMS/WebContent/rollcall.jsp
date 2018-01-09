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
	.rollRow{
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
	@MEDIA screen and (max-width: 767px) {
	#mktweb{
		display: none;
	}
	#lmsweb{
		float: left;
		width: 90%;
		height: 500px;
		overflow: scroll;
	}
	.all a{
		margin-left:0px;
	}
	div.lmsnavi{
	margin-left: 0px;
	margin-top: 25px ;
	}

}	
</style>
<script src="js/mktwebside.js"></script>
<script>
window.addEventListener("load", function(){
	
	var lecSelect = document.getElementById("lecidchk");
	
	var teacherLogin = document.querySelector("#teacherLogin");
	if(teacherLogin!=null){
		lecSelect.value=teacherLogin.value;
		lecSelect.disabled="true";
		var theads = document.getElementById("tableHeads");
		theads.style.display="block";
		
		var rollRows = document.querySelectorAll(".rollRow");
		
		//강사 분반 줄만 보이게
		for(var i=0; i<rollRows.length; i++){
			if(lecSelect.value==rollRows[i].firstChild.nextSibling.innerHTML){
				rollRows[i].style.display="block";
			}
		}	
	}
    
		
	lecSelect.addEventListener("change", function(){
		
		//lecSelect.setAttribute("selectedLecid", lecSelect.value);
		
		var theads = document.getElementById("tableHeads");
		theads.style.display="block";
		
		var rollRows = document.querySelectorAll(".rollRow");
		
		//이전 선택 지우고 초기화
		for(var i=0; i<rollRows.length; i++){
				rollRows[i].style.display="none";
		}
		
		//선택된 분반 줄만 보이게
		for(var i=0; i<rollRows.length; i++){
			if(lecSelect.value==rollRows[i].firstChild.nextSibling.innerHTML){
				rollRows[i].style.display="block";
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
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a>&nbsp/&nbsp<a href="roll.do?root=""">출결 관리 </a> /출석부 입력 </div>


<c:set var="power" value="${sessionScope.power }"></c:set>
	<c:choose>
		<c:when test="${power eq 'teach'}">
			<c:set var="profile" value="${sessionScope.powerName }"></c:set>
			<p>${profile } 강사님 환영</p>
			<c:set var="chargedClass" value="${sessionScope.lecid }"></c:set>
			<input type="hidden"  id="teacherLogin" value="${chargedClass }"/>
		</c:when>
	</c:choose>
<h3>오늘의 출석</h3>
<div>
<label for="todaymark">오늘날짜:</label>
<input type="date" id="todaymark" name="todaymark" readonly="readonly">
<script>document.getElementById('todaymark').valueAsDate = new Date();</script>
</div>

<form action="rollcall.do" method="post">
<c:set var="power" value="${sessionScope.power }"></c:set>
<c:if test="${power eq 'teach' or power eq 'mgr' }">
	<input type="hidden" name="lecidchk" value="${sessionScope.lecid }">
</c:if>
<div>
<label for="lecidchk">분반선택:</label>
<select id="lecidchk" name="lecidchk">
<!-- <select id="lecidSelect" name="lecidchk"> -->
	<option value="no" >선택하세요</option>
	<c:forEach items="${lecidList }" var="bean">
	<option value="${bean }" >${bean }</option>
	</c:forEach>
</select>
</div>

<table>
			<tr id="tableHeads">
				<th>분 반</th>
				<th>학 번</th>
				<th>이 름</th>
				<th>출 결</th>
			</tr>			
			<c:forEach items="${roll}" var="activeStudent">
				<tr class="rollRow">
					<td>${activeStudent.sclass }</td>
					<td>${activeStudent.stuid }</td>
					<td>${activeStudent.stuname }</td>
					<td>
						<select name="${activeStudent.sclass }-${activeStudent.stuid }-${activeStudent.stuname }-">
							<option value="출석" >출석</option>
							<option value="결석">결석</option>
							<option value="지각" >지각</option>
							<option value="조퇴">조퇴</option>											
						</select>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div>
		<button type="submit">입력</button>
		<button type="reset">취소</button>	
		</div>
</form>

</div>
</body>
</html>