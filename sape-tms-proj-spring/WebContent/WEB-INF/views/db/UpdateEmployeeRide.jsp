<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.sapient.tms.model.bl.CentralLogic" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<form:form action=" " method="post" modelAttribute=" " >		
		
		<form:label path="id"> Employee ID: </form:label>
		<form:input path="id" required="required"/>
		<form:label path="" >Ride:</form:label> <br>
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
					<td><form:radiobutton path="vehicleId" value="${ride.getVehicle().getId()}" /></td>
					<td>${ride.getVehicle().getBrandName()} ${ride.getVehicle().getModelName()}</td>
					<td>${ride.getVehicle().getRoute()}</td>
					<td>${ride.getPickupTime() }</td>
					
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>