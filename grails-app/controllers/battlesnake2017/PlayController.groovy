package battlesnake2017

import grails.converters.JSON

class PlayController {
    String manualCommand
    List<Game> games
    def index() { }

    def start() {
//        HOW TO ACCESS REQUEST ATTRIBUTE
//        println(params.width)
//        println(params.height)
//        println(params.game_id)

        //take in board info

        Start startRes = new Start(
                color: "#ffffff",
                head_url: "http://image.ibb.co/dOvsTv/sd.png",
                name: "z-dog",
                taunt: "hhahah"
        )
        render startRes as JSON
    }

    def move() {
        Thread.currentThread().sleep((long)(850))
        println("what: " + manualCommand)
         Move moveRes = new Move(
                move: manualCommand,
                taunt:"hotline bling"
        )
        render moveRes as JSON
    }

    def manual() { }
    def changeDirect() {
        println(params.dir)
        manualCommand = params.dir as String
        render ""
    }
}
