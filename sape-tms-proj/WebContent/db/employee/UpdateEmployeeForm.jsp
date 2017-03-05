<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		Employee Name: <input type="text" name="employeeName" required /><br>
		Vehicle id: <input type="text" name="vehicleId" required /><br>
		Are you admin(y/n):<input type="text" name="isAdmin" required /><br>
		<input type="submit" value="Submit" />
	</form>



</body>
</html>