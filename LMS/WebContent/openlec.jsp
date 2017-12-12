<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>
<style>
 #lectMonChecker{
 	display: none;
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
</style>
<script src="js/mktwebside.js"></script>
<script>
	window.addEventListener("load", function(){
		
	var 	startingMon = document.getElementById("starting");
	var 	endingMon = document.getElementById("ending");
	endingMon.addEventListener("focusout", function(){
		
		var startMonText = startingMon.value+"";
		startMonText = startMonText.replace(/-/, '');
		
		var endMonText = endingMon.value+"";
		endMonText = endMonText.replace(/-/, '');
		
		var start=Number(startMonText);
		var end=Number(endMonText);
		
		if((end-start)<=0) 
			document.querySelector("#lectMonChecker").style.display="block"
	});
	
	endingMon.addEventListener("focusin", function(){
		document.querySelector("#lectMonChecker").style.display="none"
	});
	
	var lecId = document.getElementById("lecid");
	var lecIntro = document.getElementById("intro");
		lecIntro.addEventListener("change", function(){
			var temp = lecIntro.value;
			if(temp.length<20){ //js utf-8 한글도 한글자를 길이 한칸으로 읽음.
				
			}
	});
		
	//preview div
		document.getElementById("previewBtn").addEventListener("click", function(){
			
			//preivew container style
			var previewDiv = document.createElement("div");
			previewDiv.style.width="200px";
			previewDiv.style.height="400px";
			previewDiv.style.border="thick solid gray";
			previewDiv.style.backgroundColor="white";
			previewDiv.style.opacity="0.9";
			previewDiv.style.zIndex = "30";
			
			//preveiw text (nodes)
			previewDiv.appendChild(document.createTextNode("강의코드:"+document.getElementById("lecid").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("강의명:"+document.getElementById("lecname").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("강사코드:"+document.getElementById("tid").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("강사명:"+document.getElementById("tname").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("개강:"+document.getElementById("starting").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("종강:"+document.getElementById("starting").value));
			previewDiv.appendChild(document.createElement("br"));
			previewDiv.appendChild(document.createTextNode("강의소개:"+document.getElementById("intro").value));
			previewDiv.appendChild(document.createElement("br"));
			
			//okay button to hid preview
			var previewOk = document.createElement("button");
			var buttonText = document.createTextNode("확인");
			previewOk.appendChild(buttonText);
			previewOk.style.display = "block";
			previewDiv.appendChild(previewOk);
			previewOk.addEventListener("click", function(){
				this.parentNode.style.display="none";
			});
			
			//append preview to body
			document.body.appendChild(previewDiv);
			previewDiv.style.position="absolute";
			var targetRect = document.getElementById("lecid").getBoundingClientRect();
			previewDiv.style.left=targetRect.left+"px";
			previewDiv.style.top=targetRect.top+"px";
		});
	});
</script>
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<a href="logout.do" class="logout">logout</a>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/강좌개설</div>
<h2>강좌 개설</h2>
<form id="openLec" action="openlec.do" method="post">
	<div>
		<label for="lecid">강의코드</label>
		<input type="text" name="lecid" id="lecid" value=${requestScope.nextid } readonly="readonly">
	</div>
	<div>
		<label for="lecname">강의명</label>
		<input type="text" name="lecname" id="lecname" required/>
	</div>
	<div>
		<label for="tid">강사코드</label>
		<select name="tid" id="tid" required>
			<c:forEach items="${tlist }" var="tIDlist">
				<option value=${tIDlist.tid }>${tIDlist.tid }</option>
			</c:forEach>
		</select>
	</div>	
	<div>
		<label for="tname">강사명</label>
		<select name="tname" id="tname" required>
			<c:forEach items="${tlist }" var="tNAMElist">
				<option value="${tNAMElist.tname }">${tNAMElist.tname }</option>
			</c:forEach>
		</select>
	</div>			
	<div>
		<label for="room">강의장</label>
		<select name="rid" id="rid" required>
			<c:forEach items="${room }" var="rid">
				<option value=${rid }>${rid }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="starting">개강</label>
		<input type="month" name="starting" id="starting" required>
	</div>
	<div>
		<label for="ending">종강</label>
		<input type="month" name="ending" id="ending" required>
		<p id="lectMonChecker">*종강월은 개강월 최소 1개월 이후로 입력</p>
	</div>
	<div>
		<label for="intro">강의소개</label><br>
		<textarea name="intro" id="intro" rows=5 cols=30 required></textarea>
	</div>
	<div>
		<button type="reset">폼비우기</button>
		<button type="button" id="previewBtn">미리보기</button>
		<button type="submit" id="submitBtn">DB전송</button>
	</div>			
</form>
</div>
</body>
</html>