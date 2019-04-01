<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Countdown Secure Connection</title>
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
<script type="text/javascript" src="resources/js/form_login.js"></script>
</head>

<body class="text-center">
	<div id="mongoDbServlet" class="container">

		<div>
			<img
				src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png"
				alt="CountdownLogo" />
		</div>

		<h1 class="welcome">Countdown Admin Login</h1>

		<div>&nbsp;</div>

		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">

				<!------ MONGODB JSP & SERVLET ------>
				<div id="login_form">
					<form id="user_login_form" name="loginForm" method="post"
						action="adminLogin">
						<!----- LOGIN FORM ------>
						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								class="form-control" id="login_id"
								placeholder="Enter login id ..." name="login_id" maxlength="10">
						</div>

						<div>&nbsp;</div>

						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								class="form-control" id="login_pwd"
								placeholder="Enter password ..." name="login_pwd">
						</div>

						<!----- SUBMIT BUTTON ------>
						<div>&nbsp;</div>
						<button id="submit_btn" type="submit" class="btn btn-primary btn-lg btn-block">Confirm
							identity</button>
					</form>
				</div>
				
				<div>&nbsp;</div>
				
				<div align="center">
					<h3 id="errMsg" class="p-3 mb-2 text-danger">${error_message}</h3>
				</div>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>