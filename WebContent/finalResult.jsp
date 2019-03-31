<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<!-- CSS file -->
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body class="text-center">
	<div class="container">

		<div>
			<img
				src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<div>&nbsp;</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<div class="finalRound-text">
					<h1>GAME OVER</h1>
					<h2>${sName}, your final score: ${sGameScore}</h2>
				</div>

				<div>&nbsp;</div>

				<div>
					<button class="btn btn-success btn-lg btn-block"
						onclick="hScores()">HighScores</button>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
	<script src="resources/js/links.js"></script>
</body>
</html>