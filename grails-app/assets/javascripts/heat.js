/**
 * Created by kenneth on 2017-03-04.
 */
$(document).ready(function() {
    $('.block').each(function() {
        $(this).css('background-color', $(this).attr('data-heat'));
    })
});