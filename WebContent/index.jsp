<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CountdownApp</title>
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

		<h1 class="welcome">Welcome to online Countdown</h1>
		
		<div>&nbsp;</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<div id="User_form">

					<form method="post" action="newGame">
						<!----- USER FORM ------>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" name="userName" class="form-control"
								placeholder="Enter your name ..." maxlength="20">
						</div>

						<div>&nbsp;</div>

						<!----- SUBMIT BUTTON ------>
						<button id="submit_btn" type="submit"
							class="btn btn-primary btn-lg">New Game</button>

					</form>

				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>

		<div>&nbsp;</div>

		<div class="span">
			<button class="btn btn-primary btn-lg" onclick="rules()">Rules</button>

			<div>&nbsp;</div>

			<button class="btn btn-success btn-lg" onclick="hScores()">HighScores</button>


			<script>
				function rules() {
					window.open("rules.jsp");
				}

				function hScores() {
					window.open("highScores.jsp");
				}
			</script>
		</div>

	</div>
</body>
</html>