<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="form.css">
<title>Person List</title>
</head>
<body>
	<form class="background" method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allPeople }" var="currentperson">
	<tr>
		<td><input type="radio" name="id" value="${currentperson.id }"></td>
		<td>${currentperson.fname }</td>
		<td>${currentperson.lname }</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToPerson">
	<input type="submit" value="delete" name="doThisToPerson">
	<input type="submit" value="add" name="doThisToPerson">
	</form>
	<a href="addPersonForListServlet">Create a new contact</a>
	<a href="index.html">Add a new Person</a>
</body>
</html>