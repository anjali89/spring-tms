<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>

<h2>SignIn To TMS</h2>
	<c:if test="${not empty requestScope.status }">
		<p id="errorMessage">
			<c:out value="${requestScope.status}"></c:out>
		</p>
		
	</c:if>
	<form:form action="signInCheck" method="post" commandName="employee">
	    <form:label path="id">Employee ID:</form:label> 
		<form:input type="number" path="id" /><br>
		
		<form:label path="password">Password:</form:label> 
		<form:input type="password" path="password" /> 
		
		<input type="submit" value="Submit"/> 
			<a href="./GoBack">Go back</a>
	</form:form>
</body>
</html>