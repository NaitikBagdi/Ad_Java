<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href = "css/style.css">
</head>
<body>
	<div class="container">
		<form class="form" action ="register" method="post" onsubmit="return validateForm()">
			<p class="title">Employee Register</p>
				<div class="flex">
					<label>
						<input class="input" type="text" name="firstName" id="firstname"placeholder="">
						<span>Firstname</span>
					</label>
					<label>
						<input class="input" type="text" name="lastName" id="lastname" placeholder="">
						<span>Lastname</span>
					</label>
				</div>

			<label>
				<input class="input" type="text" name="userName" placeholder="">
				<span>Username</span>
			</label>

			<label>
				<input class="input" type="password" name="password" placeholder="">
				<span>Password</span>
			</label>

			<label>
				<input class="input" name="contactNumber" type="text" placeholder="">
				<span>Contact number</span>
			</label>

			<label>
				<input class="input" type="text" name="address" placeholder="">
				<span>Address</span>
			</label>
			<button class="submit">Submit</button>
		</form>
	</div>
	<script type="text/javascript" src = "javascript/script.js"></script>
</body>
</html>