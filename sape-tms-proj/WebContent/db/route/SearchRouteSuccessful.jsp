<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Route Details</title>
</head>
<body>
	<h3>Result</h3>
	<table>
		<tr>
			<th>ID</th>
			<td>${requestScope.employee.getId() }</td>
		</tr>
		<tr>
			<th>Route Name</th>
			<td>${requestScope.vehicle.getName() }</td>
		</tr>
		<tr>
			<th>Drop List</th>
			<td>${requestScope.employee.getDropList() }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>