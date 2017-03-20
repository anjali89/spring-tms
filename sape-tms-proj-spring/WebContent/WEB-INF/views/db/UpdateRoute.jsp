<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.sapient.tms.model.bl.CentralLogic"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Route Form</title>
</head>
<body>
<h2>Update Route</h2>
<form:form action=" ">
<input type="submit" value="View all Routes" />
<br>
<br>
</form:form>
<% request.setAttribute("drops", new CentralLogic().displayAllDrops()); %>
	<c:if test="${not empty requestScope.err }">
		<p id="errorMessage"><c:out value="${requestScope.err}"></c:out></p>
	</c:if>
<form:form action=" " method="post" modelAttribute="">
		<h4>Update information</h4>
		<form:label path="id">Route ID:</form:label>
		 <input type="number" name="id" required /><br><br>
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
	</form:form>
	<a href="goBack">Come Home</a>
</body>
</html>