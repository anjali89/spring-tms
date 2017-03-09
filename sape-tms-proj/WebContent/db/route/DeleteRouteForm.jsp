<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Route Form</title>
</head>
<body>
<h3>Delete Route</h3>
	<form action="${pageContext.request.contextPath}/DeleteRoute" method="post">
		ID: <input type="number" name="id" required /><br>
		<input type="submit" value="Submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>