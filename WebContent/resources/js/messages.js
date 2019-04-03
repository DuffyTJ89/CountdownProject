// ===== Test Error messaging ==========//
// $(document).ready(function() {
//     var i = 0;
// 	$('#login_id, #login_pwd').click(function() {	    		
// 		$("#logErr").html('Blabla' + i++);
// 	});
// });

$(document).ready(function() {
	$('#login_id, #login_pwd').click(function() { //click into text fields	    		
        $('#logErr').hide(); 
        $('#conErr').hide();
    });      
    //$('#dbSaveSuccess').hide();
    $('#dbSaveErr').hide();
});
