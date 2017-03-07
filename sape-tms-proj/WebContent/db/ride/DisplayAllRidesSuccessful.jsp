<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Rides Successful</title>
</head>
<body>
<table>
		<tr>
			<th>Route Id</th>
			<th>Pickup Time</th>
			<th>Drop Time</th>
			<th>Vehicle Id</th>
			
		</tr>
		<tr>
			<c:forEach var="item" items="${requestScope.vehicles}">
				<tr>
					<td>${item.getId() }</td>
					<td>${item.getName() }</td>
					<td>${item.getVehicleId() }</td>
			
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</body>
</body>
</html>