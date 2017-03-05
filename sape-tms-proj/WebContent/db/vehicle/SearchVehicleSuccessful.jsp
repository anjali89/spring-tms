<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vehicle successful</title>
</head>
<body>
	<h3>Result</h3>
	<table>
		<tr>
			<th>ID</th>
			<td>${requestScope.vehicle.getId() }</td>
		</tr>
		<tr>
			<th>Model Name</th>
			<td>${requestScope.vehicle.getModelName() }</td>
		</tr>
		<tr>
			<th>Brand Name</th>
			<td>${requestScope.vehicle.getBrandName() }</td>
		</tr>
		<tr>
			<th>Capacity</th>
			<td>${requestScope.vehicle.getCapacity() }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>