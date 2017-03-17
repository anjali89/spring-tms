<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
	<c:if test="${not empty requestScope.status }">
		<p id="errorMessage"><c:out value="${requestScope.status}"></c:out></p>
	</c:if>
	<form:form action="SignInCheck" method="get" modelAttribute="employee">
		<form:label path="id">Employee ID:</form:label>
		<form:input path="id" type="number" />
		<form:label path="password">Password:</form:label>
		<form:password path="password" />
		<input type="submit" value="Submit">
		
	</form:form>
</body>
</html>