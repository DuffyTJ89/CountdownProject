
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Countdown</title>
</head>
<body bgcolor="#07205A">
<div style="text-align:center;">
	<img src="${pageContext.request.contextPath}/images/CountDownLogo.png" alt="CountdownLogo" />
</div>

<!-- sRoundNum sName -->
<h5 style="text-align:center;color:white; "> Welcome ${sName}</h5>

<h3 style="text-align:center;color:white;"> Round ${sRoundNum}/5</h3>
<h3 style="text-align:center;color:white;"> GameScore : ${sGameScore}/5</h3>

<h3 style="text-align:center;color:white;"> Your Letters are </h3><br>
<p  style="text-align:center;color:white;"> ${sRandomLetters}</p><br>



<form style="text-align:center;color:white;" action="FirstRunGame" method="post">
Your word : <input type="text" name="userGuess" value="">
<input type="submit" value="Submit">
</form>



</body>
</html>