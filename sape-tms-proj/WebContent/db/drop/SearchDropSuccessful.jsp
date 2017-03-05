<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Drop successful</title>
</head>
<body>
	<h3>Result</h3>
	<table>
		<tr>
			<th>ID</th>
			<td>${requestScope.drop.getId() }</td>
		</tr>
		<tr>
			<th>Name</th>
			<td>${requestScope.drop.getName() }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/AdminHomeView">Go back</a>
</body>
</html>