<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HighScores</title>
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
<script type="text/javascript" src="resources/js/loader.js"></script>
</head>

<body class="text-center">
<h1>Blablab</h1>
	<div class="container-fluid">
		<div id="loading-bg"></div>

		<div>
			<div>&nbsp;</div>
			<img id="loading-image" src="resources/images/loading.gif" alt="loading" />
			<img src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png" alt="CountdownLogo" />
		</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<h1 class="highscores-text">Database Highscores</h1>

				<table>
					<tr>
						<th>Name</th>
						<th>Score</th>
						<th>Date</th>
					</tr>
				</table>

				<a href="javascript:history.back()" class="btn btn-primary">Back</a>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>
