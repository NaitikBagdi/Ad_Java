<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
body {
	background-color: #f8f9fa;
}

.login-form {
	background-color: #ffffff;
	border-radius: 10px;
	padding: 30px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
	margin-top: 25%;
}

.btn {
	margin-top: 3%;
}
</style>
</head>
<body>
<jsp:include page = "navbar.jsp"/>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="login-form">
					<h2 class="text-center mb-4">Login</h2>
					<form action="<%=request.getContextPath()%>/login" method="post">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username" name="username" required>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password" required>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Login</button>
					</form>
					<div class="text-center mt-3">
						<p>
							Don't have an account? <a href="register.jsp">Sign up</a>
						</p>
					</div>
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