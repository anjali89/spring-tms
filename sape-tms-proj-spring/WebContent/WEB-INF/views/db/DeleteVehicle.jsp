<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Vehicle Form</title>
</head>
<body>
	<h1>Delete Vehicle</h1>
	<form:form action=" " method="post" modelAttribute=" ">
	<form:label path="id">ID:</form:label>
	 <form:input path="id" required="required" /><br>
		<input type="submit" value="Submit" />
	</form:form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>