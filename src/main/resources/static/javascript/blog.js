$(document).ready(function () {
    $('#hide').bind('input propertychange', function () {
        $('#preview').html(marked($('#hide').val()));
    })
        .trigger('input');
});