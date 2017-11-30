<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 상담</title>
</head>
<body>
<h2>이메일 상담 목록</h2>
	<table border=1>
		 <tr>
		   <th>번호</th>
		   <th>제목</th>
		   <th>내용</th>
		 </tr>
		 <c:forEach items="${list }" var="bean">
		 <tr>
		   <td><a href="b01detail.do?idx=${bean.emailId }">${bean.emailId }</a></td>
		   <td>
		   		<c:choose>
           			<c:when test="${fn:length(bean.title) > 10}">
            			<c:out value="${fn:substring(bean.title,0,9)}"/>...
           			</c:when>
           			<c:otherwise>
            			<c:out value="${bean.title}"/>
           			</c:otherwise> 
          		</c:choose>
		   </td>
		   <td>
		   		<c:choose>
           			<c:when test="${fn:length(bean.content) > 14}">
            			<c:out value="${fn:substring(bean.content,0,13)}"/>...
           			</c:when>
           			<c:otherwise>
            			<c:out value="${bean.content}"/>
           			</c:otherwise> 
          		</c:choose>
		   </td>
		 </tr>
		 </c:forEach>
	</table>
	<a href="lmsindex.do">메인으로</a>
</body>
</html>