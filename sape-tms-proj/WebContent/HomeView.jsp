<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sape TMS</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/accounts/SignInForm.jsp">Sign In</a></li>
		<li><a href="${pageContext.request.contextPath}/accounts/SignUpForm.jsp">Sign Up</a></li>
	</ul>
	<c:if test="${not empty requestScope.status }">
		<p id="status">${requestScope.status }</p>
	</c:if>
</body>
</html>