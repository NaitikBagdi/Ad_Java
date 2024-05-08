<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
/* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
} */



.logo {
	margin-left:8%;
	font-size: 30px;
	cursor: pointer;
	text-decoration: underline;
}

.header {
	top: 0%;
	position: absolute;
	width: 100%;
	height: 90px;
	background: palegoldenrod;
}

.navbar {
	margin: 30px auto;
	display: flex;
	align-items: center;
}

ul {
	flex: 1;
	text-align: right;
}

ul li {
	display: inline-block;
	list-style: none;
	margin: 0 25px;
}

ul li a {
	text-decoration: none;
	color: black;
	padding: 0 10px;
	position: relative;
}

ul li a::after {
	content: "";
	width: 0;
	height: 6px;
	background: #f14a60;
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	top: 20px;
	border-radius: 10px;
	transition: 0.5s;
}

ul li a:hover::after {
	width: 90%;
}

.navbar-icons a {
	font-size: 20px;
	color: black;
	margin: 5px;
	padding: 15px 20px;
}
</style>
</head>
<body>


	<header class="header">
		<div class="navbar">
			<!-- <a href="home.jsp"><img src="/img/logo.png"></a> -->
			<h3 class="logo">Application</h3>
			<ul>
				<li><a href="homepage.jsp">Home</a></li>
				<li><a href="#">About me</a></li>
				<li><a href="#">Menu</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<div class="navbar-icons">
				<!--  <a href="login.jsp"><img src="img/login.png"></a>
            <a href="register.jsp"><img src="img/sign-up.png"></a> -->

				<a href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i></a>
				<a href="register.jsp"><i class="fa-solid fa-user-plus"></i></a>
			</div>
		</div>
	</header>
</body>
</html>