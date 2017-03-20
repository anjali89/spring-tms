<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vehicle Form</title>
</head>
<body>
	<h1>Insert Drop</h1>
	<form:form action="  " method="post" modelAttribute=" ">
		<form:label path="id">Name:  </form:label>
		<form:input path="name" required="required" /><br>
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>