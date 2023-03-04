<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
	<p> </p>
	<table>
	
	<c:forEach items="${requestScope.allLists }" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id }"></td>
		<td><h2>${currentlist.listName }</h2></td></tr>
		<tr><td colspan="3">Date Created: ${currentlist.dateCreated }</td></tr>
		<tr><td colspan="3">Address: ${currentlist.contact }</td></tr>
		<c:forEach var="listVal" items="${currentlist.person}">
		<tr><td></td><td colspan="3">${listVal.fname }, ${listVal.lname }</td></tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToList">
	<input type="submit" value="delete" name="doThisToList">
	<input type="submit" value="add" name="doThisToList">
	</form>
	<a href="addPeopleForListServlet">Create a new contact</a>
	<a href="index.html">Add a new Person</a>

</body>
</html>