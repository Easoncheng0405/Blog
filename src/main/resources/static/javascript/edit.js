$(document).ready(function () {
    $(".btn-publish").click(function () {// validation
        if ($('#title').val().trim() === '')
            return $('.alert-danger').html('标题不能为空').show();
        $('form').submit();
    });
    $('#content')
        .bind('input propertychange', function () {
            $('#preview').html(marked($('#content').val()));
        })
        .trigger('input');
});