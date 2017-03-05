<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Drop Form</title>
</head>
<body>
	<h1>Delete Drop</h1>
	<form action="${pageContext.request.contextPath}/DeleteDrop" method="post">
		ID: <input type="number" name="id" required /><br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>