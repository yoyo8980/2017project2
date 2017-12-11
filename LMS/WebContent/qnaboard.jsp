<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/all.css"></link>
<script src="js/mktwebside.js"></script>
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
</head>
<body>
<div id="mktweb"><c:import url="startweb.do"  charEncoding="utf-8"></c:import></div>
<div id="lmsweb" class="all">
<div class="lmsnavi">현재위치: <a href="lmsindex.do">LMS</a>/QnA관리</div>
<h2>Questions 목록</h2>
	<table>
		 <tr>
		   <th>번호</th>
		   <th>작성자</th>
		   <th>내용</th>
		 </tr> 
		 <c:forEach items="${questionList }" var="bean">
		 <tr>
		   <td><a href="qnadetail.do?idx=${bean.qnaid }">${bean.qnaid  }</a></td>
		   <td>${bean.author }</td>
		   <td>
		   		<c:choose>
           			<c:when test="${fn:length(bean.content) > 10}">
            			<c:out value="${fn:substring(bean.content,0,9)}"/>...
           			</c:when>
           			<c:otherwise>
            			<c:out value="${bean.content}"/>
           			</c:otherwise> 
          		</c:choose>
		   </td>
		 </tr>
		 <tr>
		 	<td align="right"></td>
		 	<td colspan=2>
		 		댓글 개수: 
		 		<c:set var="key" value="${bean.qnaid }"></c:set>
		 		<c:out value="${repCnt[key]}"></c:out>
		 	</td>
		 </tr>
		 </c:forEach>
	</table>
	<div>
	<a href="lmsindex.do">메인으로</a>
	</div>
</div>	
</body>
</html>