<%@ page import="ie.gmit.sw.AttributeKeys" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Final Result</title>
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
<script type="text/javascript" src="resources/js/messages.js"></script>
<script type="text/javascript" src="resources/js/loader.js"></script>
</head>

<body class="text-center">
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

				<div>
					<h1 class="game-over-text">GAME OVER</h1>
					<h3 class="white-text"> <span class="name-text"> <%= session.getAttribute(AttributeKeys.SESSION_USER_NAME) %>'s </span>
						round <span class="rounds-text"> <%= session.getAttribute(AttributeKeys.SESSION_ROUND_NUM) %> </span>
						score: <span class="total-score-text"> <%= request.getAttribute(AttributeKeys.USER_ROUND_SCORE) %> </span></h3>
					<h3 class="white-text">Guess Word: <span class="rand-letters-text"> <%= request.getParameter(AttributeKeys.USER_GUESS_WORD) %> </span></h3>
					<h3 class="final_score-text">Final Game Score: <span class="total-score-text"> <%= session.getAttribute(AttributeKeys.SESSION_TOTAL_SCORE) %> </span></h3>
				</div>

				<div>
					<a class="btn btn-primary btn-lg btn-block" href="welcome.jsp">New Game</a>
					<div>&nbsp;</div>
					<a class="btn btn-warning btn-lg btn-block" href="index.jsp">Log Out</a>
					<div>&nbsp;</div>
					<a class="btn btn-success btn-lg btn-block" href="DisplayHighScores" target="_blank">High Scores</a>
				</div>

				<div>&nbsp;</div>

				<div align="center">
					<h3 class="p-3 mb-2 text-danger">${data_save_fail}</h3>
					<h3 class="p-3 mb-2 text-danger">${data_save_success}</h3>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>
