<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Rides Successful</title>
</head>
<body>
	<table border="2">

		<tr>
			<th>Route Id</th>
			<th>Vehicle Id</th>
			<th>Pickup Time</th>
			<th>Drop Time</th>
			<th>Seats Allocated</th>


		</tr>
		<tr>
			<c:forEach var="ride" items="${requestScope.rides}">
				<tr>
					<td>${ride.getVehicle().getId() }</td>
					<td>${ride.getRoute().getId()}</td>
					<td>${ride.getPickupTime() }</td>
					<td>${ride.getDropTime() }</td>
					<td>${ride.getSeatsAllocated() }</td>


				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</body>
</body>
</html>