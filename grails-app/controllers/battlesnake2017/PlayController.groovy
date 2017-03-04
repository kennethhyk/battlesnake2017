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
                you: "",
                snakes: [],
                foods: [],
                deadsnakes: [],
                state: 1,
                next: "",
                squareList: []
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
        Game game = null
        for(Game temp in games){
            if(temp.game_id == request.JSON.game_id as String){
                game = temp
                game.color = ""
                game.turn += 1
                game.you = request.JSON.you as String
                List reqSnakes = request.JSON.snakes as List
                println(reqSnakes)
                for(snake in reqSnakes){
                    List<Coordinate> coords = []
                    for(coord in snake.coords) {
                        coords.add(new Coordinate(x:coord[0] as int, y:coord[1] as int))
                    }
                    game.snakes.add(new Snake(
                            id: reqSnakes.id[0],
                            taunt: reqSnakes.taunt[0],
                            name: reqSnakes.name[0],
                            health_points: reqSnakes.health_points[0] as int,
                            coords: coords
                    ))
                }
                game.foods = []
                game.deadsnakes = []
                break
            }

        }

        Move moveRes = new Move(
                move: game.Next(),
                taunt:"hotlinebling"
        )
        render moveRes as JSON
    }
}
