package battlesnake2017

import grails.converters.JSON

class PlayController {
    static scope = "singleton"

    List<Game> games = []

    def index() { }

    def start() {
//        HOW TO ACCESS REQUEST ATTRIBUTE

        //take in board info
        int isExist = 0
        for(Game temp in games){
            if(temp.game_id == request.JSON.game_id as String){
                temp.width = request.JSON.width as int
                temp.height = request.JSON.height as int
                temp.game_id = request.JSON.game_id as String
                temp.color = ""
                temp.turn = 0
                temp.you = ""
                temp.snakes = []
                temp.foods = []
                temp.deadsnakes = []
                temp.state = 1
                temp.next = ""
                temp.squareList = []
                temp.mySnake = null
                temp.heatmap = []
                isExist = 1
                temp.heatmap = new Heatmap(game: temp, board: [])
                for(int i = 0; i < temp.width;i++) {
                    for(int j = 0; j < temp.height;j++){
                        temp.heatmap.board.add(new Coordinate(i,j))
                    }
                }
                break
            }
        }
        if(!isExist) {
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
                    squareList: [],
                    mySnake: null,
                    heatmap: []
            )
            moves.heatmap = new Heatmap(game: moves, board: [])
            for(int i = 0; i < moves.width;i++) {
                for(int j = 0; j < moves.height;j++){
                    moves.heatmap.board.add(new Coordinate(i,j))
                }
            }
            games.add(moves)
        }
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
                game.snakes = []
                List reqSnakes = request.JSON.snakes as List
                for(snake in reqSnakes){
                    List<Coordinate> coords = []
                    for(coord in snake.coords) {
                        coords.add(new Coordinate(coord[0] as int, coord[1] as int))
                    }
                    game.snakes.add(new Snake(
                            id: reqSnakes.id[0],
                            taunt: reqSnakes.taunt[0],
                            name: reqSnakes.name[0],
                            health_points: reqSnakes.health_points[0] as int,
                            coords: coords
                    ))
                }
                for(Snake snake in game.snakes)
                {
                    if(game.you == snake.id)
                    {
                        game.mySnake = snake
                    }
                }
                game.foods = []
                List reqFoods = request.JSON.food as List
                for(food in reqFoods){
                    game.foods.add(new Coordinate(food[0], food[1]))
                }
                game.deadsnakes = []
                break
            }


        }
        for(Coordinate coords in game.heatmap.board) {
            coords.heat = 0.5
        }
        for(Coordinate food in game.foods) {
            Coordinate coords = game.heatmap.board.find { it.x == food.x && it.y == food.y }
            if(coords) {
                coords.heat = coords.heat - 0.3
            }
        }
        for(Snake snakeBody in game.snakes) {
            for(Coordinate coords in snakeBody.coords){
                Coordinate c = game.heatmap.board.find { it.x == coords.x && it.y == coords.y }
                if(c) {
                    c.heat = c.heat + 0.3
                }
            }
        }
//        for(Coordinate coords in game.heatmap.board) {
//            //food
//            if(game.radiation(game.foods).find{it.x == coords.x && it.y == coords.y}){
//                coords.heat -= 0.1
//            }
            //snake
//            for(Snake s in game.snakes) {
//                if(game.radiation(s.coords).find{it.x == coords.x && it.y == coords.y}){
//                    coords.heat += 0.2
//                }
//            }
//        }
        game.computeState()
        Move moveRes = new Move(
                move: game.Next(),
                taunt:"hotlinebling"
        )
        render moveRes as JSON
    }

    def heatmap() {
        Game game = null
        for(Game temp in games){
            if(temp.game_id == params.game_id){
                game = temp
            }
        }
        return [heatmap: game.heatmap]
    }
}
