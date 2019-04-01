// $(document).ready(function() {
//     var i = 0;
// 	$('#login_id, #login_pwd').click(function() {	    		
// 		$("#errMsg").html('Blabla' + i++);
// 	});
// });


// $(document).ready(function() {
// 	$('#login_id, #login_pwd, #nick').click(function() { //click into text fields	    		
//         $("#errMsg").hide();
//         $("#errNick").hide();
// 	});
// });


$(document).ready(function() {
	$('#login_id, #login_pwd').click(function() { //click into text fields	    		
        $("#errMsg").hide();
    });
    
    $('#nick').click(function() { //click into text fields	    		
        $("#errNick").hide();
	});
});
