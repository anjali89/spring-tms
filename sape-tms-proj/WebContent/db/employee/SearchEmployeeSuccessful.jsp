<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.sapient.tms.model.bean.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee Details</title>
</head>
<body>
	<h3>Result</h3>
	<table border="2" cellpadding="2">
		<tr>
			<th>ID</th>
			<td>${requestScope.employee.getId() }</td>
		</tr>
		<tr>
			<th>Name</th>
			<td>${requestScope.employee.getName() }</td>
		</tr>
		<tr>
			<th>Vehicle Id</th>
			<td>${requestScope.employee.getRide().getVehicle().getId() }</td>
		</tr>
		<tr>
			<th>Vehicle</th>
			<%System.out.println(((Employee)request.getAttribute("employee")).getRide().getVehicle()); %>
			<td>${requestScope.employee.getRide().getVehicle().getBrandName() } ${requestScope.employee.getRide().getVehicle().getModelName() }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>