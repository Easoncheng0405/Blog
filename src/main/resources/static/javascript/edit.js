$(document).ready(function(){
    $(".btn-publish").click(function(){// validation
        if($('#title').val().trim()==='')
            return $('.alert-danger').html('标题不能为空').show();
        $('form').submit();
    });


    //if($('body#edit').length === 0) return;
    $('#description')
        .bind('input propertychange', function(){
            $('#preview').html(marked($('#description').val()));
        })
        .trigger('input');
});