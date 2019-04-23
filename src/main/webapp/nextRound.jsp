<%@ page import="ie.gmit.sw.AttributeKeys" %>
<%@ page import="ie.gmit.sw.RoundResult" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Next Round</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
          crossorigin="anonymous">
    <!-- CSS file -->
    <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- jQuery File, js scriptss -->
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/loader.js"></script>
    <script type="text/javascript" src="resources/js/timer.js"></script>
    <script type="text/javascript" src="resources/js/form_autosubmit.js"></script>
    <script type="text/javascript" src="resources/js/audio.js"></script>
</head>

<body class="text-center">

<audio id="audio_sound" src="resources/mp3/CountdownClock.mp3" type="audio/mpeg" preload="auto"></audio>

<div class="container-fluid">
    <div id="loading-bg"></div>

    <div>
        <div>&nbsp;</div>
        <img id="loading-image" src="resources/images/loading.gif" alt="loading"/>
        <img src="${pageContext.request.contextPath}/resources/images/CountDownLogo.png" alt="CountdownLogo"/>
        <p><span id="timer">30</span></p>
    </div>

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">

            <div>
                <h3 class="white-text">Round: <span class="rounds-text"> <%= session.getAttribute(AttributeKeys.SESSION_ROUND_NUM) %> / <%= RoundResult.NO_OF_ROUNDS %> </span></h3>
                <h3 class="white-text">Game Score: <span class="total-score-text"> <%= session.getAttribute(AttributeKeys.SESSION_TOTAL_SCORE) %> </span></h3>
                <h3 class="white-text">Letters: <span class="rand-letters-text"> ${randLetters} </span></h3>
            </div>

            <div>&nbsp;</div>

            <div>
                <form id="word_form" action="RoundResult" method="post" >

                    <div class="input-group input-group-lg">
							<span class="input-group-addon"> <i
                                    class="glyphicon glyphicon-pencil"></i>
							</span> <input type="text" name="userGuessWord" value=""
                                           class="form-control" placeholder="Enter Your Word ..."
                                           maxlength="10">
                    </div>

                    <div>&nbsp;</div>

                    <button id="submit_btn" type="submit"
                            class="btn btn-primary btn-lg btn-block">Submit Word
                    </button>
                </form>
            </div>

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