<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Route Form</title>
</head>
<body>
	<h3>Search Route</h3>
	<form:form action=" " method="post" modelAttribute=" ">
		<form:label path="id ">	ID:</form:label>
		<form:input path="id" required="required" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
	<a href="goBack">Come Home</a>
</body>
</html>