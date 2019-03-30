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

	<h5 style="text-align: center; color: white;">${sName}, your
		results :</h5>

	<h3 style="text-align: center; color: white;">Round :
		${sRoundNum}/5</h3>
	<h3 style="text-align: center; color: white;">Your word :
		${sUserWord}</h3>
	<h3 style="text-align: center; color: white;">GameScore :
		${sGameScore}</h3>

	<!-- <button style="text-align:center;color:red;" type="button" action="FirstRunGame" method="post">Move to next round</button> -->

	<form style="text-align: center;" action="ContinueGame" method="post">
		<input type="submit" name="button1" value="Move to next round" />
	</form>



</body>
</html>