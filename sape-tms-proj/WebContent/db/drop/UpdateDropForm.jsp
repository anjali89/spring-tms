<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Drop Form</title>
</head>
<body>
	<h1>Update Drop</h1>
	<form action="${pageContext.request.contextPath}/UpdateDrop" method="post">
		ID: <input type="number" name="id" required /><br>
		Name: <input type="text" name="name" required /><br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>