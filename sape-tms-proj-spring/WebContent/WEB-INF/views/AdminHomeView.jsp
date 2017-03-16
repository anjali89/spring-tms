<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/ViewRequests">View Requests</a></li>
		<li><a href="${pageContext.request.contextPath}/SignOut">Sign Out</a></li>
	</ul>
	<c:if test="${not empty requestScope.status }">
		<p id="status">${requestScope.status }</p>
	</c:if>
</body>
</html>