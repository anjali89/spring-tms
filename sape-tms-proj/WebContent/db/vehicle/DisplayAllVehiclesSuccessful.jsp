<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display all vehicles successful</title>
</head>
<body>
	<h3>Result</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Model Name</th>
			<th>Brand Name</th>
			<th>Capacity</th>
		</tr>
		<tr>
			<c:forEach var="item" items="${requestScope.vehicles}">
				<tr>
					<td>${item.getId() }</td>
					<td>${item.getModelName() }</td>
					<td>${item.getBrandName() }</td>
					<td>${item.getCapacity() }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>