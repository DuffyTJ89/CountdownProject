<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CountdownApp</title>

<!-- CSS File -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">

<style type="text/css">
body {
	background: navy !important;
}
.welcome{
color: red;
}
</style>

</head>

<!-- <body bgcolor="#07205A"> -->
<body class="text-center">

	<div class="container">

		<div>
			<img
				src="${pageContext.request.contextPath}/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<div>&nbsp;</div>

		<h1 class="welcome">Welcome to online Countdown</h1>

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
							class="btn btn-primary btn-lg">Start New Game</button>

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

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" class="form-control" /> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4"></div>
		</div>
		<!-- /.row -->

	</div>

</body>
</html>