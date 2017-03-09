<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Vehicle Form</title>
</head>
<body>
	<h1>Delete Vehicle</h1>
	<form action="${pageContext.request.contextPath}/DeleteVehicle" method="post">
		ID: <input type="text" name="id" required /><br>
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>