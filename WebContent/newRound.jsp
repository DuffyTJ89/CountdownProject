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

		<div>
			<img
				src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<div>&nbsp;</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<div class="rounds-text">
					<!-- sRoundNum sName -->
					<h3>Welcome ${sName}</h3>
					<h3>Round: ${sRoundNum}/5</h3>
					<h3>GameScore: ${sGameScore}</h3>
					<h3>Your Letters are:</h3>
					<h3>${sRandomLetters}</h3>
				</div>

				<div>&nbsp;</div>

				<div id="Word_form">
					<form action="ContinueRunGame" method="post">

						<div class="input-group input-group-lg">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-pencil"></i>
							</span> <input type="text" name="userGuess" value=""
								class="form-control" placeholder="Enter Your Word ..."
								maxlength="10">
						</div>

						<div>&nbsp;</div>

						<button id="submit_btn" type="submit"
							class="btn btn-success btn-lg btn-block">Submit Word</button>
					</form>
				</div>

				<div class="col-lg-4"></div>
			</div>
		</div>

	</div>
</body>
</html>