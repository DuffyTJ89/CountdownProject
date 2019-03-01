<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CountdownApp</title>

<style> <!--css-->
#center-align {
  text-align: center;
}
</style>
</head>
<body bgcolor="#07205A">
<div style="text-align:center;">
	<img src="C:\Users\Thomas\eclipse-workspace\JSPCountdown\Countdown\Img\CountDownLogo.png" alt="CountdownLogo">
</div>
<h1 style="text-align:center;color:white;">Welcome to online Countdown</h1>


<form action="newGame" method="post">
    <p style="text-align:center;color:white;">Enter your name : </p>
    <div style="text-align:center;">
    <input  type="text" name="userName" size="20"></div>
    <br><br>
    <div style="text-align:center;">
    <input type="submit" value="Start New Game"></input></div>
</form>


</body>
</html>