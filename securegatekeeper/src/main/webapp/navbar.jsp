<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SecureGateKeeper</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
.nav-link {
margin-right: 10%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-info">
		<a class="navbar-brand text-dark" style="margin-left: 2%;" href="navbar.jsp">SecureGateKeeper</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end" style="margin-right: 5%;" id="navbarNav">
			<ul class="navbar-nav"style = "width:300px; display:flex; justify-content: space-between;">
				<li class="nav-item active "><a class="nav-link text-dark" href="navbar.jsp">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link text-dark" href="https://github.com/NaitikBagdi" target="_blank">About</a></li>
				<li class="nav-item"><a class="nav-link text-dark" href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link text-dark" href="login.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>