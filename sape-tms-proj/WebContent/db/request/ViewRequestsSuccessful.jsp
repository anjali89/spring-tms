<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.sapient.tms.model.bl.CentralLogic"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
	<%
		request.setAttribute("centralLogic", new CentralLogic());
	%>
	<h3>Result</h3>
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
						<select>
							<option selected="${tempRequest.isAccepted()?'selected':'' }">ACCPETED</option>
							<option selected="${tempRequest.isRejected()?'selected':'' }">REJECTED</option>
							<option selected="${tempRequest.isPending()?'selected':'' }">PENDING</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>