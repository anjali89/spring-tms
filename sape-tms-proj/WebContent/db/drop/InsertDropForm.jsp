<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vehicle Form</title>
</head>
<body>
	<h1>Insert Drop</h1>
	<form action="${pageContext.request.contextPath}/InsertDrop" method="post">
		Name: <input type="text" name="name" required /><br>
		<input type="submit" value="submit" />
	</form>
</body>
</html>