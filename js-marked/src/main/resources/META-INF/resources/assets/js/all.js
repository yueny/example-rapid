// 初始化内容
$(function() {
    $('textarea')
        .on('input', OnInput)
        .on('propertychange', OnPropChanged);
});

// Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
function OnInput (event) {
    var htmlVal= marked(event.target.value);
    $('#mahua-result').html(htmlVal);
}
// Internet Explorer
function OnPropChanged (event) {
    //.
}
