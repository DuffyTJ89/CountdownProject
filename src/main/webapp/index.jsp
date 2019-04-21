<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
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

				<h1 class="red-text">Countdown User Login</h1>

				<div>&nbsp;</div>

				<div id="login_form">
					<form id="user_login_form" name="UserLogin" method="post"
						action="UserLogin">

						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								class="form-control" id="login_id"
								placeholder="Enter Name ..." name="login_id" maxlength="10">
						</div>

						<div>&nbsp;</div>

						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								class="form-control" id="login_pwd"
								placeholder="Enter Password ..." name="login_pwd">
						</div>

						<div>&nbsp;</div>
						<button id="submit_btn" type="submit"
							class="btn btn-primary btn-lg btn-block">Log In</button>
					</form>
				</div>
				
				<div>&nbsp;</div>

				<div align="center">
					<h3 id="logErr" class="p-3 mb-2 text-danger">${login_error}</h3>
					<h3 id="conErr" class="p-3 mb-2 text-danger">${connection_error}</h3>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>