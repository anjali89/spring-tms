<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ride Form</title>
</head>
<body>
	<h1>Update Ride Details</h1>
	<form action="${pageContext.request.contextPath}/UpdateRide"
		method="post">
		Vehicle Id: <input type="text" name="vehicle" required /><br>
		Route Id: <input type="text" name="route" required /><br> Pickup
		Pickup Time: <input type="time" name="pickupTime" required /><br>
		Drop Time:<input type="time" name="dropTime" required /><br>
		Seats Allocated:<input type="number" name="seatsAllocated" required /><br>
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>