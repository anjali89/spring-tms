<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
	<c:if test="${not empty requestScope.status }">
		<p id="errorMessage"><c:out value="${requestScope.status}"></c:out></p>
	</c:if>
	<form action="${pageContext.request.contextPath}/SignIn" method="post">
		Employee ID: <input type="number" name="id" />
		Password: <input type="password" name="password" />
		<input type="submit" value="Submit">
		<a href="${pageContext.request.contextPath }/HomeView.jsp">Go back</a>
	</form>
</body>
</html>