<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.sapient.tms.model.bl.CentralLogic"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Route Form</title>
</head>
<body>
<h2>Route Form Fillup</h2>
<% request.setAttribute("drops", new CentralLogic().displayAllDrops()); %>
	<c:if test="${not empty requestScope.err }">
		<p id="errorMessage"><c:out value="${requestScope.err}"></c:out></p>
	</c:if>
<form action="${pageContext.request.contextPath}/InsertRoute" method="post">
		ID: <input type="number" name="id" required /><br>
		Name: <input type="text" name="name" required /><br>
		
		Drop: <br>
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