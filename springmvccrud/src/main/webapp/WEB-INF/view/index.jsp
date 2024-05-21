<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Student Form</h2>
	<form action="${pageContext.request.contextPath}/student/add" method="post">
		Name: <input type="text" name="name"><br>
		Address: <input type="text" name="address"><br>
		Pincode: <input type="text" name="pincode"><br> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>