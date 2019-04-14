//https://stackoverflow.com/questions/41951367/showing-loader-while-navigating-between-pages-pwa
$(function() {
  $('#loading-bg').hide();
  $('#loading-image').hide();

  $(window).on('beforeunload', function() {
    $('#loading-bg').show();
    $('#loading-image').show();
  });
});