<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="registerpage.dto.UserRegistrationDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
}

.main {
	margin-top: 7%;
}

h2 {
	margin-bottom: 15px;
	justify-content: center;
	display: flex;
}

.btn {
	background-color: rgb(1, 206, 1);
	color: white; padding : 10px;
	border-radius: 10px;
	font-size: 15px;
	margin-left: 10px;
	margin-bottom: 10px;
	cursor: pointer;
	padding: 10px;
	border:none;
}

#table-style {
	border-collapse: collapse;
	width: 100%;
}

#table-style td, #table-style th {
	border: 1px solid #ddd;
	padding: 8px;
}

#table-style tr:hover {
	background-color: #ddd;
}

#table-style th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #ffaf1a;
	color: white;
}
</style>
</head>
<body>
	<%-- <%
	List<UserRegistrationDTO> list = (List<UserRegistrationDTO>) request.getAttribute("registrationList");
	%>

	<table>
	<thead>
			<tr>
				<th>Registration_id</th>
				<th>FName</th>
				<th>LName</th>
				<th>Email</th>
				<th>Password</th>
				<th>Gender</th>
				<th>City</th>
				<th>Comment</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i)%></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table> --%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main">
		<h2>Register Student List</h2>
		 <a href="https://www.google.com" ><button class="btn"> ADD</button></a>
    <a href="https://www.google.com" ><button class="btn"> UPDATE</button></a>
    <a href="https://www.google.com" ><button class="btn"> DELETE</button></a>
		<table id="table-style">
			<thead>
				<tr>
					<th>Registration_id</th>
					<th>FName</th>
					<th>LName</th>
					<th>Email</th>
					<th>Password</th>
					<th>Gender</th>
					<th>City</th>
					<th>Comment</th>
				</tr>
			</thead>

			<c:if test="${not empty registrationList}">
				<tbody>
					<c:forEach items="${registrationList}" var="lst">
						<tr>
							<td><c:out value="${lst.id }"></c:out></td>
							<td><c:out value="${lst.fname }"></c:out></td>
							<td><c:out value="${lst.lname }"></c:out></td>
							<td><c:out value="${lst.email }"></c:out></td>
							<td><c:out value="${lst.password }"></c:out></td>
							<td><c:out value="${lst.gender }"></c:out></td>
							<td><c:out value="${lst.city }"></c:out></td>
							<td><c:out value="${lst.comment }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</table>
	</div>
</body>
</html>