<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Month Orders Sum</title>
</head>
<body style="color: green;">
	The following are the monthly orders of 
	<c:if test="${!empty theYear}">
				year : <c:out value="${theYear}"/> <br>
	</c:if>
	<ul>
	<c:forEach items="${objectList}" var="object">
		<li>
		    <a href="${pageContext.request.contextPath}/days/${object[1]}/${theYear}">  
		    Month  : <c:out value="${object[1]}"/>;  
		    Orders : <c:out value="${object[0]}" />; 
		    Sum    : <c:out value="${object[2]}"/> </a>
	</c:forEach>
	</ul>
</body>
</html>