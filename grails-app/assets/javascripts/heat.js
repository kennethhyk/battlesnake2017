/**
 * Created by kenneth on 2017-03-04.
 */
$(document).ready(function() {
    $('.block').each(function() {
        var heat = parseFloat($(this).attr('data-heat'));
        if(heat < 0.5 ) {
            //cold
            heat = 1-(heat/0.5);
            $(this).css('background-color', 'rgb(0,0,255)');
            $(this).css('opacity', heat);
        } else {
            //hot
            heat = (heat-0.5)/0.5;
            $(this).css('background-color', 'rgb(255,0,0)');
            $(this).css('opacity', heat);
        }
    })
});