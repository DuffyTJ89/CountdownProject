<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Countdown Rules</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<!-- CSS file -->
<link href="resources/style.css" rel="stylesheet" type="text/css" />
</head>

<body class="text-center">
	<div class="container">
	
		<div style="text-align: center;">
			<img
				src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<h5 style="text-align: center; color: white;">1) The player will
			have 5 rounds to score as many points as they can</h5>
		<h5 style="text-align: center; color: white;">2) The player will
			have be given 10 random letters with which they must make a valid
			English word</h5>
		<h5 style="text-align: center; color: white;">3) The more letters
			from the 10 given the player uses the higher their score will be</h5>
		<h5 style="text-align: center; color: white;">4) The player does
			NOT have to use all the letter and is permitted to use letters
			outside the 10 but will not receive points for those letters</h5>
		<h5 style="text-align: center; color: white;">5) The player's
			word will be check against the Oxford English Dictionary and only
			words present in said dictionary will be accepted</h5>


		<h5 style="text-align: center; color: white;">Letter values are
			as follows :</h5>
		<h5 style="text-align: center; color: white;">1 point : E, A, I,
			O, N, R, T, L, S, U</h5>
		<h5 style="text-align: center; color: white;">2 points : D, G</h5>
		<h5 style="text-align: center; color: white;">3 points : B, C, M,
			P</h5>
		<h5 style="text-align: center; color: white;">4 points : F, H, V,
			W, Y</h5>
		<h5 style="text-align: center; color: white;">5 points : K</h5>
		<h5 style="text-align: center; color: white;">8 points : J, X</h5>
		<h5 style="text-align: center; color: white;">10 points : Q, Z</h5>



	</div>
</body>
</html>