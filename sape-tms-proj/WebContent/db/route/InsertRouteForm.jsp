<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.sapient.tms.model.bl.CentralLogic"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<th>ID</th>
				<th>Drop name</th>
				
			</tr>
			<c:forEach var="drop" items="${requestScope.drops
			 }">
				<tr>
					<td><input type="checkbox" name="${drop.getId()}" value="${drop.getId()}" /></td>
					<td>${drop.getId()}</td>
					<td><input type="text" value="${drop.getName()}" "fixed value" readonly/> </td>
					
				</tr>
			</c:forEach>
		</table>
		
		<!-- Drop point ID: <input type="number" name="dropId" required /><br> -->
		<!-- Drop place name: <input type="text" name="dropName" required /><br> -->
		<input type="submit" value="submit" />
	</form>
</body>
</html>