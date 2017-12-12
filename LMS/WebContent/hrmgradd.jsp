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
	#hrmgrSpan {
		color: red;
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
	form{
		margin-left:40px;
	}
	#in input{
		margin-left: 40px;
	}
</style>
<script src="js/mktwebside.js"></script>
<script type="text/javascript">
window.addEventListener("load", function(){
	var idVal = document.getElementById("webid");
	var spans=document.querySelectorAll('span');
	idVal.addEventListener("change", function(){
		spans[0].innerText='';
        
		if(!isNaN(idVal.value)){
			spans[0].innerText='숫자만 입력 하지마시오';
			idVal.value="";
		}
	});
	
	var pwVal = document.getElementById("webpw");
	pwVal.addEventListener("change", function(){
		
        spans[1].innerText='';
       
		if(pwVal.value.length<8){
			spans[1].innerText='8자이상 작성';
			pwVal.value="";
		}
	});	
});

</script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<a href="logout.do" class="logout">logout</a>
<div class="lmsnavi">현재위치: <a href="lmsindex.do"> LMS </a><a href="hrmgr.do?root="""> /계정 관리 </a> /직원 입력 </div>
	<h2>직원 입력</h2>
	
		<form action="hrmgrinsert.do" method="post">
			<div>
				ID:<input type="text" name="webid" id="webid" required/>
				
			</div>
			<div>
				<span id="hrmgrSpan"></span>
			</div>
			<div>
				PW:<input type="password" name="webpw" id="webpw" required/>
						
			</div>
			<div>
				<span id="hrmgrSpan"></span>
			</div>
			<div>
				<c:forEach items="${list }" var="bean" begin="${list.size()-1 }" end="${list.size()-1}">
						NUM:<input type="text" name="hrid" value="${bean.hrid }" readonly="readonly" id="hrid"/>
				</c:forEach>
			</div>
			<div>
				NAME:<input type="text" name="hrname" id="hrname" required/>

			</div>
			<div>
				<span id="hrmgrSpan"></span>
			</div>
			<div> 
		   Team:<select name="hrteam" required>
		    	  <c:forEach items="${list }" var="bean" begin="0" end="${list.size()-2 }">   	  		
		          		<option value="${bean.team}">${bean.team}</option>
		          </c:forEach>
		         </select>
         	</div>
	        <div id="in">               
				<input type="submit" value="입력" > 
				<input type="submit" value="취소">	
			</div>
		</form>
	</div>

</body>
</html>