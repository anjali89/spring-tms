<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>EmployeeHome View</h1>
	<ul>
	
	
		
		<li><a href="ViewAllRoutes">View all routes</a></li>
		<li><a href="employeeDel">Unsubscribe</a></li>
		<li><a href="signOut">Sign Out</a></li>		
		
	</ul>
	<c:if test="${not empty requestScope.status }">
		<p id="status">${requestScope.status }</p>
	</c:if>
	<br><br>
	<a href=./goBack>Come Home</a>
	
</body>
</html>