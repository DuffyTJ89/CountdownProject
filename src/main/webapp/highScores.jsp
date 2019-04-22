<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>High Scores</title>
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
<script type="text/javascript" src="resources/js/messages.js"></script>
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

				<h1 class="red-text">Database High Scores</h1>
				<h3 id="conErr" class="p-3 mb-2 text-danger">${connection_error}</h3>

				<table class="table">
					<thead>
						<tr>
							<th class="text-center">Name</th>
							<th class="text-center">Score</th>
							<th class="text-center">Date</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${topTen}" var="gameResult" >
							<tr>
								<td>${gameResult.userName}</td>
								<td>${gameResult.gameScore}</td>
								<td>${gameResult.date}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>
</body>
</html>
