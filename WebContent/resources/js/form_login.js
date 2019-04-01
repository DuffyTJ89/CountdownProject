// ===== Test Error messaging ==========//
// $(document).ready(function() {
//     var i = 0;
// 	$('#login_id, #login_pwd').click(function() {	    		
// 		$("#errMsg").html('Blabla' + i++);
// 	});
// });

$(document).ready(function() {
	$('#login_id, #login_pwd').click(function() { //click into text fields	    		
        $("#errMsg").hide();
	});
});
