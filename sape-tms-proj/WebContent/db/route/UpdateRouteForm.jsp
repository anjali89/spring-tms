<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.sapient.tms.model.bl.CentralLogic"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Route Form</title>
</head>
<body>
<h2>Update Route</h2>
<form action="DisplayAllRoutesForm.jsp">
<input type="submit" value="View all Routes" />
<br>
<br>
</form>
<% request.setAttribute("drops", new CentralLogic().displayAllDrops()); %>
	<c:if test="${not empty requestScope.err }">
		<p id="errorMessage"><c:out value="${requestScope.err}"></c:out></p>
	</c:if>
<form action="${pageContext.request.contextPath}/UpdateRoute" method="post">
		<h4>Update information</h4>
		Route ID: <input type="number" name="id" required /><br><br>
		Route Name: <input type="text" name="routeName" required /><br>
		
		Choose Drop Points: <br>
		<table>
			<tr>
			<th>Select</th>
				
				<th>Drop name</th>
				
			</tr>
			<c:forEach var="drop" items="${requestScope.drops
			 }">
				<tr>
					<td><input type="checkbox" value="${drop.getId()}" name="check" /></td>
					
					<td>${drop.getName()}</td>
					
				</tr>
			</c:forEach>
		</table>
		
		<!-- Drop point ID: <input type="number" name="dropId" required /><br> -->
		<!-- Drop place name: <input type="text" name="dropName" required /><br> -->
		<input type="submit" value="submit" />
	</form>
	<a href="${pageContext.request.contextPath }/AdminHomeView.jsp">Go back</a>
</body>
</html>