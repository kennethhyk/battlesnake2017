package battlesnake2017

/**
 * Created by kenneth on 2017-03-02.
 */
class Game {
    String color
    int turn
    int width
    String you
    List<Snake> snakes
    int height
    String game_id
    List<Coordinate> foods
    List<Snake> deadsnakes
    int state
    String next

//    Game(int width, int height, String id){
//        this.width = width
//        this.height = height
//        this.game_id = id
//        this.color = ""
//        this.turn = 0
//        this.you = UUID
//        this.snakes = []
//        this.foods = []
//        this.deadsnakes = []
//        this.state = 1
//        this.next = ""
//
//    }



    final List<Snake> getSnakes() {
        return snakes
    }

    def Next(){
        if(state == 1){
           return Sleepy()
        }
    }

    String Sleepy(){
        for(Snake snake in snakes)
        {
            if(you == snake.id)
            {
                Coordinate head = new Coordinate()
                head = snake.body[0]
                for(int i=1;i <= snake.body.length;i++){
                    Coordinate body = new Coordinate()
                    body = snake.body[i]
                    if(snake.body.length  ){}
                        if(head.x < body.x && head.y == body.y){
                            this.next = "up"
                            return next
                        }else if(head.x > body.x && head.y == body.y){
                            this.next = "down"
                            return next

                        }else if(head.x == body.x && head.y < body.y){
                            this.next = "left"
                            return next
                        }else if(head.x == body.x && head.y > body.y){
                            this.next = "right"
                            return next
                        }
                }
            }

        }
        this.next = "down"
        return next
    }

}
