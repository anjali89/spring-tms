<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Vehicle Form</title>
</head>
<body>
	<h3>Search Vehicle</h3>
	<form action="${pageContext.request.contextPath}/SearchVehicle"
		method="post">
		ID: <input type="text" name="id" required /><br> <input
			type="submit" value="Submit" />

		<h1>Search Vehicle</h1>
		<form action="${pageContext.request.contextPath}/SearchVehicle"
			method="post">
			ID: <input type="text" name="id" required /><br> <input
				type="submit" value="Submit" />
		</form>
</body>
</html>