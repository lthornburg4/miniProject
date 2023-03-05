<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="form.css">
<title>Edit List</title>
</head>
<body class="background">
	<form class="background" action="editListDetailsServlet" method="post">
	<input type="hidden" name="id" value="${listToEdit.id }">
	List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />
	
	Date Created: <input type="text" name="month" placeholder="mm" size="4" value="${month }">
	<input type="text" name="day" placeholder="dd" size="4" value="${day }">, 
	<input type="text" name="year" placeholder="yyyy" size="4" value="${year }">
	
	Address: <input type="text" name="contact" value="${listToEdit.contact }"><br />
	
	Available People: <br />
	
	<select name="allPeopleToAdd" multiple size="6">
	<c:forEach items="${requestScope.allPeople }" var="currentperson">
	<option value="${currentperson.id }">${currentperson.fname } ${currentperson.lname }</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Save Changes">
	</form>
	<a href="index.html">Add more people</a>
</body>
</html>