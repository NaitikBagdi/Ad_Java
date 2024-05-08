<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registraion</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
body {
	background-color: #f8f9fa;
}

.registration-form {
	background-color: #ffffff;
	border-radius: 10px;
	padding: 30px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
	margin-top: 25%;
}

.btn {
	margin: 3%;
}
</style>
</head>
<body>
	<%
	// Retrieve the error message attribute from the session
	String errorMessage = (String) session.getAttribute("errormessage");
	// Check if errorMessage is not null
	if (errorMessage != null) {
	%>
	<script>
			// Display the error message in an alert box
			alert("<%=errorMessage%>");
	</script>
	<%
	}
	%>
<jsp:include page="navbar.jsp" />
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="registration-form">
					<h2 class="text-center mb-4">Register</h2>
					<form action="<%=request.getContextPath()%>/register" method="post">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username" name="username" required>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" name="email" required>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password" required>
						</div>
						<div class="form-group">
							<label for="confirmPassword">Confirm Password</label> <input
								type="password" class="form-control" id="confirmPassword"
								name="confirmPassword" required>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>