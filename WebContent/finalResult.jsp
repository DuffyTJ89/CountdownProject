<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<!-- CSS file -->
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<!-- jQuery File, js scripts -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/button_links.js"></script>
<script type="text/javascript" src="resources/js/messages.js"></script>
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

		<div>&nbsp;</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<div class="finalRound-text">
					<h1>GAME OVER</h1>
					<h2>${sName},yourfinal score: ${sGameScore}</h2>
				</div>

				<div>&nbsp;</div>

				<div>
					<button class="btn btn-success btn-lg btn-block"
						onclick="hScores()">HighScores</button>
				</div>

				<div>&nbsp;</div>

				<div>
					<button id="submit_btn" type="submit"
						class="btn btn-primary btn-lg btn-block" onclick="newGame()">New
						Game</button>
				</div>

				<div>&nbsp;</div>

				<div align="center">
					<h3 class="p-3 mb-2 text-danger">${db_save_error}</h3>
					<h3 class="p-3 mb-2 text-danger">${db_save_success}</h3>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>
