<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Result</h3>
	<table border="2" cellpadding="2">
		<tr>
			<th>Route Id</th>
			<td>${requestScope.ride.getRoute() }</td>
		</tr>
		<tr>
			<th>Vehicle Id</th>
			<td>${requestScope.ride.getVehicle() }</td>
		</tr>
		<tr>
			<th>Pickup Time</th>
			<td>${requestScope.ride.getPickupTime() }</td>
		</tr>
		<tr>
			<th>Drop Time</th>
			<td>${requestScope.ride.getDropTime() }</td>
		</tr>
		<tr>
			<th>Seats Allocated</th>
			<td>${requestScope.ride.getSeatsAllocated() }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>