<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Countdown</title>
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

		<!-- sRoundNum sName -->
		<h5 style="text-align: center; color: white;">Welcome ${sName}</h5>

		<h3 style="text-align: center; color: white;">Round
			${sRoundNum}/5</h3>
		<h3 style="text-align: center; color: white;">GameScore :
			${sGameScore}</h3>

		<h3 style="text-align: center; color: white;">Your Letters are</h3>
		<br>
		<p style="text-align: center; color: white;">${sRandomLetters}</p>
		<br>



		<form style="text-align: center; color: white;"
			action="ContinueRunGame" method="post">
			Your word : <input type="text" name="userGuess" value=""> <input
				type="submit" value="Submit">
		</form>


	</div>
</body>
</html>