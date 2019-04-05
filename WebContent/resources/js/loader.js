//https://stackoverflow.com/questions/23906956/show-loading-icon-until-the-page-is-load
// document.onreadystatechange = function () {
//   var state = document.readyState
//   if (state == 'interactive') {
//        document.getElementById('contents').style.visibility="visible";
//   } else if (state == 'complete') {
//       setTimeout(function(){
//          document.getElementById('interactive');
//          document.getElementById('load').style.visibility="hidden";
//          document.getElementById('contents').style.visibility="visible";
//       },1000);
//   }
// }

//https://stackoverflow.com/questions/41951367/showing-loader-while-navigating-between-pages-pwa
$(function() {
  $('#loading-bg').hide();
  $('#loading-image').hide();

  $(window).on('beforeunload', function() {
    $('#loading-bg').show();
    $('#loading-image').show();
  });
});