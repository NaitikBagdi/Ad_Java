<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<form class="form" id="formId" method="post">
			<p class="title">Employee Register</p>
			<div class="flex">
				<label>
					<input class="input" type="text" name="firstName" id="firstname" placeholder="" oninput="validateTextField(this,'firstname')">
					<span>Firstname</span>
					<span id="firstname-message"></span>
				</label>

				<label>
					<input class="input" type="text" name="lastName" id="lastname" placeholder="" oninput="validateTextField(this,'lastname')">
					<span>Lastname</span>
					<span id = "lastname-message"></span>
				</label>
			</div>

			<label>
				<input class="input" type="text" name="username" id="username" placeholder="">
				<span>Username</span>
				<span id = "user-message"></span>
			</label>

			<label>
				<input class="input" type="password" name="password" id="password" placeholder="" oninput="validatePasswordField(input)">
				<span>Password</span>
				<span id = "password-message"></span>
			</label>

			<label>
				<input class="input" type="text" name="contactnumber" id="contactnumber" placeholder="" oninput="validateContactNumber(this)">
				<span>Contact number</span>
				<span id = "contact-message"></span>
			</label>

			<label>
				<input class="input" type="text" name="address" id="address"placeholder="">
				<span>Address</span>
				<span id = "address-message"></span>
			</label>

			<button class="submit" name="submitRequest" id="registerButton" value="submit">Submit</button>
			<div id = "required-message"></div>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
			<script type="text/javascript" src="javascript/script.js"></script>
		</form>
	</div>
</body>
</html>