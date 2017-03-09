<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Ride</title>
</head>
<body>

	<h1>Enter Ride Details</h1>
	<form action="${pageContext.request.contextPath}/InsertRide"
		method="post">
		Vehicle ID: <input type="text" name="vehicleId" required /><br>
		Route ID: <input type="number" name="routeId" required /><br>
		PickUp Time: <input type="text" name="pickupTime" required /><br>
		Drop Time: <input type="text" name="dropTime" required /><br>
		Seats Allocated: <input type="number" name="seatsAllocated" required /><br>
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>