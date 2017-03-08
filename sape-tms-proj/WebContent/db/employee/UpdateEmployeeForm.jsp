<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Form</title>
</head>
<body>
	<h1>Update Employee Details</h1>
	<form action="${pageContext.request.contextPath}/UpdateEmployee" method="post">
		ID: <input type="text" name="id" required /><br>
		New Password: <input type="password" name="password" required /><br>
		Employee Name: <input type="text" name="name" required /><br>
		Vehicle id: <input type="text" name="vehicleId" required /><br>
		<input type="submit" value="Submit" />
	</form>



</body>
</html>