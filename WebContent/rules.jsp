<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">html>
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
<!-- jQuery Files -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body class="text-center">
	<div class="container">

		<div>
			<img
				src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<h1 class="welcome">Countdown Rules</h1>

		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">

				<div class="rules-text">
					<h4>1) The player will have 5 rounds to score as many points
						as they can</h4>
					<h4>2) The player will have be given 10 random letters with
						which they must make a valid English word</h4>
					<h4>3) The more letters from the 10 given the player uses the
						higher their score will be</h4>
					<h4>4) The player does NOT have to use all the letter and is
						permitted to use letters outside the 10 but will not receive
						points for those letters</h4>
					<h4>5) The player's word will be check against the Oxford
						English Dictionary and only words present in said dictionary will
						be accepted</h4>

					<h3 class="lettersValueHeader-text">Letter values are as
						follows:</h3>
					<h4>1 point : E, A, I, O, N, R, T, L, S, U</h4>
					<h4>2 points : D, G</h4>
					<h4>3 points : B, C, M, P</h4>
					<h4>4 points : F, H, V, W, Y</h4>
					<h4>5 points : K</h4>
					<h4>8 points : J, X</h4>
					<h4>10 points : Q, Z</h4>
				</div>

			</div>
			<div class="col-lg-2"></div>
		</div>

	</div>
</body>
</html>