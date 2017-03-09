<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Ride</title>
</head>
<body>

	<h1>Delete Ride</h1>
	<form action="${pageContext.request.contextPath}/DeleteRide"
		method="post">
		Enter Vehicle ID: <input type="text" name="vehicleId" required /><br> <input
			type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>