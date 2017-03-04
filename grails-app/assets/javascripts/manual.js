/**
 * Created by kenneth on 2017-03-03.
 */

$(document).ready(function() {
    $(document).keydown(function(event){
        if(String.fromCharCode(event.which) == "W") {
            $.ajax({
                url: "/play/changeDirect",
                data: {'dir': "up"}
            });
        } else if(String.fromCharCode(event.which) == "A") {
            $.ajax({
                url: "/play/changeDirect",
                data: {'dir': "left"}
            });
        } else if(String.fromCharCode(event.which) == "S") {
            $.ajax({
                url: "/play/changeDirect",
                data: {'dir': "down"}
            });
        } else if(String.fromCharCode(event.which) == "D") {
            $.ajax({
                url: "/play/changeDirect",
                data: {'dir': "right"}
            });
        }
    });
});