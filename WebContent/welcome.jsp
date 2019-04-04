<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CountdownApp</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<!-- CSS file -->
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<!-- jQuery File, js scriptss -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/button_links.js"></script>
<script type="text/javascript" src="resources/js/loader.js"></script>
</head>

<body class="text-center">
	<div class="container-fluid">
		<div id="loading-bg"></div>
		<img id="loading-image" src="resources/images/loading.gif"
			alt="loading" />

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

					<form action="newGame" method="post">
						<!----- USER FORM ------>
						<div class="input-group input-group-lg">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" name="userName" class="form-control"
								placeholder="Enter Your Name ..." maxlength="20">
						</div>

						<div>&nbsp;</div>

						<!----- SUBMIT BUTTON ------>
						<button id="submit_btn" type="submit"
							class="btn btn-primary btn-lg btn-block">New Game</button>
					</form>
				</div>

				<div>&nbsp;</div>

				<div>
					<button class="btn btn-warning btn-lg btn-block" onclick="rules()">Rules</button>

					<div>&nbsp;</div>

					<button class="btn btn-success btn-lg btn-block"
						onclick="hScores()">HighScores</button>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>