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
	
}

form {
	top: 170px;
	position: absolute;
	width: 280px;
	transition: 0.5s;
}

.input-group {
	top: 150px;
	position: absolute;
	width: 280px;
	transition: 0.5s;
}

.input-group {
	padding: 40px 40px;
	background: #ffbb73;
	height: 30%;
	left: 40%;
	border-radius: 20px;
}

.input-field {
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	color: black;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
}

.submit-btn {
	top: 50px;
	position: relative;
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
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>  
<p style= "color:red; background-color:yellow;margin-top:90px;">${INVALID}</p>

	<div class="Main">
		<form method="post" action="login" id="login" class="input-group">
			<input type="text" name="fname" class="input-field" placeholder="User-id" required>
			<input type="password" name="password" class="input-field" placeholder="Enter password"
				required>
			<button type="submit" class="submit-btn">Log in</button>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>