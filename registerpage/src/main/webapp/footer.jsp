<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
}

html {
	height: 100%; 
}

body {
	background-color: rgb(235, 178, 73);
	height: 100%;
	display: flex;
	flex-direction: column;
}

footer {
	background: palegoldenrod;
	margin-top: auto;
	color: black;
}

.footer-content {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	text-align: center;
}

.footer-content h3 {
	font-size: 1.8rem;
	font-weight: bold;
	text-transform: capitalize;
	line-height: 3rem;
}

.footer-content p {
	max-width: 500px;
	margin: 10px auto;
	line-height: 28px;
	font-size: 14px;
}

.footer-bottom {
	background: palegoldenrod;
	width: 100vw;
	padding: 20px 0;
	text-align: center;
}

.footer-bottom p {
	font-size: 14px;
	word-spacing: 2px;
	text-transform: uppercase;
}

.footer-bottom span{
	text-transform: uppercase;
	opacity: .4;
	font-weight: 200;
}
</style>
</head>
<body>
	<footer>
		<div class="footer-content">
			<h3>Todo Application</h3>
			<p>Naitik Bagdi, Gmail- NaitikBagdi01@gamil.com,
				Pratapgarh,Rajasthan 312605</p>
		</div>
		<div class="footer-bottom">
			<p>
				copyright & copy;2024 codeOpacity. degined by 
				<span>Naitik Bagdi</span>
			</p>
		</div>
	</footer>
</body>
</html>