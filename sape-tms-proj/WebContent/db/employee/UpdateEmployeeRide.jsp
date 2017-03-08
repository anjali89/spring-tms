<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.sapient.tms.model.bl.CentralLogic" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ride</title>
</head>
<body>
	<% request.setAttribute("rides", new CentralLogic().displayAllAvailableRides()); %>
	<c:if test="${not empty requestScope.err }">
		<p id="errorMessage"><c:out value="${requestScope.err}"></c:out></p>
	</c:if>
	<h1>Update Ride</h1>
	<form action="${pageContext.request.contextPath}/ChangeRide" method="post">		
		
		Employee ID: <input type="number" name="id" required/>
		Ride: <br>
		<table>
			<tr>
				<th>Select</th>
				<th>Vehicle</th>
				<th>Route</th>
				<th>Pickup Start</th>
				
			</tr>
			<c:forEach var="ride" items="${requestScope.rides
			 }">
				<tr>
					<td><input type="radio" name="vehicleId" value="${ride.getVehicle().getId()}" /></td>
					<td>${ride.getVehicle().getBrandName()} ${ride.getVehicle().getModelName()}</td>
					<td>${ride.getVehicle().getRoute()}</td>
					<td>${ride.getPickupTime() }</td>
					
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>