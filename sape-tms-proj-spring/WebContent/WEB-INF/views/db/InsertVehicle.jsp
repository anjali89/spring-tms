<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vehicle Form</title>
</head>
<body>
	<h1>Insert Vehicle</h1>
	<form:form action=" " method="post" modelAttribute=" ">
	<form:label path="id">ID:</form:label> 
	<form:input path="id" required="required"/><br>
	<form:label path="modelName">	Model Name:</form:label>
	 <form:input path="modelName" required="required" /><br>
	<form:label path=brandName">	Brand Name:</form:label> 
	<form:input path="brandName" required="required" /><br>
	<form:label path="capacity">Capacity: </form:label>
	<form:input path="capacity" required="required" /><br>
		<input type="submit" value="Submit" />
	</form:form>
	<a href="goBack">Come Home</a>
</body>
</html>