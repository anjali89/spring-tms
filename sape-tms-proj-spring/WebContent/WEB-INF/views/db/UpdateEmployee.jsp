<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Form</title>
</head>
<body>
	<h1>Update Employee Details</h1>
	<form:form action="  " method="post"modelAttribute="employee">
		<form:label path="id">ID:</form:label>
	    <form:input path="id" required="required" /><br>
		<form:label path="password">New Password: </form:label>
		<form:password path="password" required="required" /><br>
		<form:label path="name">Employee Name:</form:label>
		<form:input type="text" path="name" required="required"/><br>
		<form:label path="vehicleId">Vehicle id:</form:label>
		<form:input path="vehicleId" required="required" /><br>
		<input type="submit" value="Submit" />
	</form:form>



</body>
</html>