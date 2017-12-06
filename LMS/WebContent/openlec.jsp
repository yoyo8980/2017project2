<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>강좌 개설</title>
<script src="js/mktwebside.js"></script>
</head>
<body>
<div id="mktweb"><c:import url="index01.jsp"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/강좌개설</div>
<p>강좌 개설</p>
<form id="openLec" action="openlec.do" method="post">
	<div>
		<label for="lecid">강의코드</label>
		<input type="text" name="lecid" id="lecid" value=${requestScope.nextid } readonly="readonly">
	</div>
	<div>
		<label for="lecname">강의명</label>
		<input type="text" name="lecname" id="lecname"/>
	</div>
	<div>
		<label for="tid">강사코드</label>
		<select name="tid" id="tid">
			<c:forEach items="${tlist }" var="tIDlist">
				<option value=${tIDlist.tid }>${tIDlist.tid }</option>
			</c:forEach>
		</select>
	</div>	
	<div>
		<label for="tname">강사명</label>
		<select name="tname" id="tname">
			<c:forEach items="${tlist }" var="tNAMElist">
				<option value="${tNAMElist.tname }">${tNAMElist.tname }</option>
			</c:forEach>
		</select>
	</div>			
	<div>
		<label for="room">강의장</label>
		<select name="rid" id="rid">
			<c:forEach items="${room }" var="rid">
				<option value=${rid }>${rid }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="starting">개강</label>
		<input type="month" name="starting" id="starting">
	</div>
	<div>
		<label for="ending">종강</label>
		<input type="month" name="ending" id="ending">
	</div>
	<div>
		<label for="intro">강의소개</label><br>
		<textarea name="intro" id="intro" rows=5 cols=30></textarea>
	</div>
	<div>
		<button type="reset">폼비우기</button>
		<button type="button" id="preview">미리보기</button>
		<button type="submit">DB전송</button>
	</div>			
</form>

<script>
	
	//a very primitive way to show preivew with anonymous function
	
	document.getElementById("preview").addEventListener("click", function(){
		//preivew container style
		var previewDiv = document.createElement("div");
		previewDiv.style.width="200px";
		previewDiv.style.height="400px";
		previewDiv.style.border="thick solid gray";
		previewDiv.style.backgroundColor="white";
		previewDiv.style.opacity="0.8";
		previewDiv.style.zIndex = "2";
		
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
		previewDiv.style.left="200px";
		previewDiv.style.top="50px";
	});
</script>
</div>
</body>
</html>