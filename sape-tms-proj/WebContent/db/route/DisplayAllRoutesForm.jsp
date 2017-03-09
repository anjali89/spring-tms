<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.sapient.tms.model.bl.CentralLogic"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Route list</h2>
<% request.setAttribute("routes", new CentralLogic().displayAllRoutes()); %>
	<c:if test="${not empty requestScope.err }">
		<p id="errorMessage"><c:out value="${requestScope.err}"></c:out></p>
	</c:if>
	<form action="${pageContext.request.contextPath}/UpdateRoute" method="post">
	<br>
		<table>
			<tr>
			<th>ID</th>
				
				<th>Route name</th>
				
			</tr>
			<c:forEach var="route" items="${requestScope.routes
			 }">
				<tr>
					<td>${route.getId()}</td>
					
					<td>${route.getName()}</td>
					
				</tr>
			</c:forEach>
		</table>
		</form>
		<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>