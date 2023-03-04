<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Person</title>
</head>
<body>
	<form action="editPersonServlet" method="post">
	First name: <input type="text" name="fname" value="${toEdit.fname }">
	Last name: <input type="text" name="lname" value="${toEdit.lname }">
	<input type="hidden" name="id" value="${toEdit.id }">
	<input type="submit" value="Save Changes">
	</form>
</body>
</html>