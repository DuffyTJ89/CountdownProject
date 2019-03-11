<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#07205A">
<div style="text-align:center;">
	<img src="C:\Users\Thomas\eclipse-workspace\JSPCountdown\Countdown\Img\CountDownLogo.png" alt="CountdownLogo">
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
	 -->
	 
	 <h5 style="text-align:center;color:white; "> ${sName}, your results :</h5>
	 
	 <h3 style="text-align:center;color:white;"> Round : ${sRoundNum}/5</h3>
	 <h3 style="text-align:center;color:white;"> GameScore : ${sGameScore}</h3>
	 
	 <button style="text-align:center;color:red;" type="button" onclick="alert('GOING')">Move to next round</button>
	 
	 

</body>
</html>