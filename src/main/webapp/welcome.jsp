<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ie.gmit.sw.AttributeKeys" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
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

<body class="text-center text-white">
	<div class="container-fluid">
		<div id="loading-bg"></div>

        <div>
            <div>&nbsp;</div>
            <img id="loading-image" src="resources/images/loading.gif" alt="loading" />
            <img src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png" alt="CountdownLogo" />
        </div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="text-white col-lg-4">

				<h1 class="red-text">Welcome to Countdown</h1>

				<h3 class="white-text">Name: <span class="name-text"> <%= session.getAttribute(AttributeKeys.SESSION_USER_NAME) %> </span></h3>

				<div>&nbsp;</div>

				<a class="btn btn-primary btn-lg btn-block" href="NewGame">New Game</a>

				<div>&nbsp;</div>

				<div>
					<a class="btn btn-warning btn-lg btn-block" href="rules.jsp" target="_blank">Rules</a>
					<div>&nbsp;</div>
					<a class="btn btn-success btn-lg btn-block" href="DisplayHighScores" target="_blank">High Scores</a>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>