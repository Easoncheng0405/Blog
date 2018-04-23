$(document).ready.$(document).ready(function () {
    alert('123');
    $('#content').html(marked($('${blog.content}').val()));
});