<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Vehicle Form</title>
</head>
<body>
	<h1>Update Vehicle</h1>
	<form action="${pageContext.request.contextPath}/UpdateVehicle" method="post">
		ID: <input type="text" name="id" required /><br>
		Model Name: <input type="text" name="modelName" required /><br>
		Brand Name: <input type="text" name="brandName" required /><br>
		Capacity: <input type="number" name="capacity" required /><br>
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>