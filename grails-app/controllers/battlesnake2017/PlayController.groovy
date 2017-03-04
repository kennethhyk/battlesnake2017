package battlesnake2017

import grails.converters.JSON

class PlayController {
    List<Game> games = []

    def index() { }

    def start() {
//        HOW TO ACCESS REQUEST ATTRIBUTE

        //take in board info

        Game moves = new Game(
                width: request.JSON.width as int,
                height: request.JSON.height as int,
                game_id: request.JSON.game_id as String,
                color: "",
                turn: 0,
                you: UUID as String,
                snakes: [],
                foods: [],
                deadsnakes: [],
                state: 1,
                next: ""
        )
        games.add(moves)
        Start startRes = new Start(
                color: "#ffffff",
                head_url: "http://placecage.com/c/100/100",
                name: "z-dog",
                taunt: "hhahah"
        )
        render startRes as JSON
    }

    def move() {

        Game game1 = null
        for(Game game in games){
            println(game.game_id)
            println(params.game_id)
            if(game.game_id == params.game_id){
                game1 = game
//                println(game.game_id)
//                println(params.game_id)
                break
            }

        }

        Move moveRes = new Move(
                move: game1.Next(),
                taunt:"hotlinebling"
        )
        render moveRes as JSON
    }
}
