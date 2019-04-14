//https://stackoverflow.com/questions/31106189/create-a-simple-10-second-countdown
$("document").ready(function(){
    var time_left = "30";
    var downloadTimer = setInterval(function() {
        time_left--;
        document.getElementById("timer").innerText  = time_left;
        if(time_left <= 0) {
            clearInterval(downloadTimer);
        }
    },1000);
});