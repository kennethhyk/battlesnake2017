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

    final List<Snake> getSnakes() {
        return snakes
    }

    String Next(){
        if(state == 1){
           return Sleepy()
        }
    }

    String Sleepy(){
        for(Snake snake in snakes){
            for(Coordinate coordinate in snake.body) {
                //asdaadssss
            }

        }
    }

}
