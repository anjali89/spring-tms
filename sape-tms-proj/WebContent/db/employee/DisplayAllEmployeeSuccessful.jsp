<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All successful</title>
</head>
<body>
	<h3>Result</h3>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Employee Name</th>
			<th>Vehicle Id</th>
			<th>Vehicle</th>
		</tr>
		<tr>
			<c:forEach var="employee" items="${requestScope.employees}">
				<tr>
					<td>${employee.getId() }</td>
					<td>${employee.getName() }</td>
					<td>${employee.getRide().getVehicle().getId() }</td>
					<td>${employee.getRide().getVehicle().getBrandName() } ${employee.getRide().getVehicle().getModelName() }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>