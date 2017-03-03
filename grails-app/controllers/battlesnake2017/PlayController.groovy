package battlesnake2017

import grails.converters.JSON

class PlayController {

    def index() { }

    def start() {
//        HOW TO ACCESS REQUEST ATTRIBUTE
//        println(params.width)
//        println(params.height)
//        println(params.game_id)

        //take in board info

        Start startRes = new Start(
                color: "#ffffff",
                head_url: "http://placecage.com/c/100/100",
                name: "z-dog",
                taunt: "hhahah"
        )
        render startRes as JSON
    }

    def move() {
        Game game = new Game(gameid: 1)
        render game as JSON
    }
}