<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Ride</title>
</head>
<body>

	<h1>Delete Ride</h1>
	<form:form action=" " method="post" modelAttribute=" ">
	 <form:label path="vehicleId"> Enter Vehicle ID:</form:label>
	  <form:input path="vehicleId" required="required" /><br> <input
			type="submit" value="Submit" />
	</form:form>
	<a href="goBack">Come Home</a>
</body>
</html>