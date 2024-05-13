<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Employee Registration List</h2>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Contact Number</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td><c:out value="${employee.firstName}" /></td>
				<td><c:out value="${employee.lastName}" /></td>
				<td><c:out value="${employee.userName}" /></td>
				<td><c:out value="${employee.contactNumber}" /></td>
				<td><c:out value="${employee.address}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>