<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="form.css">
<title>Create New List</title>
</head>
<body class="background">
	<form class="background" action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Date Created: <input type="text" name="month" placeholder="mm" size="4">
	<input type="text" name="day" placeholder="dd" size="4">, 
	<input type="text" name="year" placeholder="yyyy" size="4">
	Address: <input type="text" name="contact" size="50"><br />
	
	Available People: <br />
	
	<select name="allPeopleToAdd" multiple size="6">
	<c:forEach items="${requestScope.allPeople }" var="currentperson">
	<option value="${currentperson.id }">${currentperson.fname } ${currentperson.lname }</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create contact and Add people">
	</form>
	<a href="index.html">Add more People</a>
</body>
</html>