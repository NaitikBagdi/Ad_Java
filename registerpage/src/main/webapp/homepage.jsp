<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>


.middle {
	margin-top:18%;
	padding: 50px;
	display: flex;
}

h2 {
	font-size: 40px;
}

.middle h2 {
	margin: 0 5px;
}

.title {
	font-size: 40px;
	font-weight: bold;
	color: red;
}

.middle {
	white-space: nowrap;
	overflow: hidden;
	animation: marquee 8s linear infinite;
}

@keyframes marquee { 0% {transform: translateX(100%);}
100%{transform:translateX(-100%);}}


</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="middle">
		<h2 class="title">Wellcome</h2>
		<h2>Programming</h2>
		<h2 class="title">World....</h2>
		<span></span>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>