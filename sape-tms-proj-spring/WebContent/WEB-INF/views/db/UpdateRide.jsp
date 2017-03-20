<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ride Form</title>
</head>
<body>
	<h1>Update Ride Details</h1>
	<form:form action=" " method="post" modelAttribute=" ">
	<form:label path="vehicleId"> Vehicle Id: </form:label>
	<form:input path="vehicle" required="required" /><br>
	<form:label path="routeId">	Route Id:</form:label> 
	<form:input path="route" required="required" /><br> 
	<form:label path="pickupTime">	Pickup Time:</form:label>
    <form:input type="time" path="pickupTime" required="required" /><br>
	<form:label path="dropTime">	Drop Time:</form:label>
	<form:input type="time" path="dropTime" required="required" /><br>
	<form:label path="seatsAllocated">	Seats Allocated:</form:label>
	<form:input path="seatsAllocated" required="required" /><br>
	<input type="submit" value="Submit" />
	</form:form>
	<a href="goBack">Come Home</a>
</body>
</html>