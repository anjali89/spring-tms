<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.sapient.tms.model.bl.CentralLogic"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<script
  src="https://code.jquery.com/jquery-3.1.1.js"
  integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ViewRequestsSuccessful.js"></script>
</head>
<body>
	<h3>Result</h3>
	<form action="./UpdateRequests">
		<table>
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Requested Vehicle</th>
				<th>Vehicle Seats Allocated / Capacity</th>
				<th>Status</th>
			</tr>
			<tr>
				<c:forEach var="tempRequest" items="${requestScope.requests}">
					<tr>
						<td>${tempRequest.getEmployee().getId() }</td>
						<td>${tempRequest.getEmployee().getName() }</td>
						<td>${tempRequest.getEmployee().getRide().getVehicle().getBrandName()}
							${tempRequest.getEmployee().getRide().getVehicle().getModelName()}</td>
						<td>${tempRequest.getEmployee().getRide().getSeatsAllocated()}/
							${tempRequest.getEmployee().getRide().getVehicle().getCapacity()}</td>
						<td>
							<select name="status">
								<option selected="${tempRequest.isAccepted()?'selected':'' }">ACCPETED</option>
								<option selected="${tempRequest.isRejected()?'selected':'' }">REJECTED</option>
								<option selected="${tempRequest.isPending()?'selected':'' }">PENDING</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<input type="button" id="editButton" value="Edit" />
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>