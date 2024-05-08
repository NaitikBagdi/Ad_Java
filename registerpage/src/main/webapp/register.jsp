<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: rgb(247, 170, 193);
}

.main {
	width: 400px;
	position: relative;
	margin: 6% auto;
	padding: 5px;
}
.main h1{
	margin-top:20px;
	text-decoration:underline;
}

form {
	margin-top:20px;
	width: 280px;
	transition: 0.5s;
}

.input-field {
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
}

::placeholder {
	color: Black;
	opacity: 1;
}

.commemt {
	width: 100%;
	padding: 10px;
	margin: 5px;
	background: transparent;
	border-color: #000000;
	border-style: groove;
}

.submit-btn {
	width: 85%;
	padding: 10px 30px;
	cursor: pointer;
	display: block;
	margin: auto;
	background: linear-gradient(to right, #ff105f, #ffad06);
	border: none;
	outline: none;
	border-radius: 30px;
}

.check-box {
	margin: 30px 10px 30px 0;
}

.check {
	color: black;
	font-size: 12px;
	bottom: 68px; 
	position: absolute;
}
</style>
</head>
<body>
 <p style= "color:red; background-color:yellow;margin-top:90px">${Successfull}</p>
 <jsp:include page="header.jsp"></jsp:include>
	<div class="main">
		<h1>Registration Page</h1>
		<form action="<%=request.getContextPath()%>/register" method="post" >

			<input type="text" class="input-field" name="fname"
				placeholder="First Name " required> <input type="text"
				class="input-field" name="lname" placeholder="Last Name " required>
			<input type="email" class="input-field" name="email"
				placeholder="Email Id" required> <input type="password"
				class="input-field" name="password" placeholder="*********" required>
			<input type="radio" name="gender" value="male">Male <input
				type="radio" name="gender" value="female">Female <select
				class="input-field" name="city">
				<option value="Select Your city ">Select Your city</option>
				<option value="indore">Indore</option>
				<option value="Pratapgarh">Pratapgarh</option>
				<option value="Mandsaour">Mandsaour</option>
				<option value="jaipur">jaipur</option>
			</select> Comment Here :
			<textarea name="comment" cols="30" rows="5" class="commemt"
				placeholder="Enter Here ...." required></textarea>
			<input type="checkbox" class="check-box" name="checkbox" required><span class="check">I
				agree to the terms and conditions </span>
			<button type="submit" class="submit-btn" onclick="myFunction()">Register</button>
		</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>