<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body bgcolor="#07205A">
	<div style="text-align: center;">
		<img src="${pageContext.request.contextPath}/images/CountDownLogo.png"
			alt="CountdownLogo" />
	</div>
	<!-- 
					request.setAttribute("sRoundNum", roundNum);
					session.setAttribute("sRoundNum", roundNum);
					request.setAttribute("sRandomLetters", randomLetters);
					session.setAttribute("sRandomLetters", randomLetters);
					request.setAttribute("sName", yourName);
					session.setAttribute("sName", yourName);
					request.setAttribute("sGameScore", gameScore);
					session.setAttribute("sGameScore", gameScore);
					sUserWord
					
					<form style="text-align:center;color:white;" action="FirstRunGame" method="post">
						Your word : <input type="text" name="userGuess" value="">
					<input type="submit" value="Submit">
</form>
	 -->
	<h5 style="text-align: center; color: white;">GAME OVER :</h5>
	<h2 style="text-align: center; color: white;">${sName}, your
		results :</h2>

	<h3 style="text-align: center; color: white;">Final GameScore :
		${sGameScore}</h3>





</body>
</html>