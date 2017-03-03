package battlesnake2017

/**
 * Created by kenneth on 2017-03-02.
 */
class Coordinate {
    int x
    int y


    boolean isSafe(int x,int y){
        Game lizheng = new Game()
        List<Snake> snakes = lizheng.getSnakes()
        for(Snake snake in snakes){
            for(Coordinate coordinate in snake.body) {
                if (x == coordinate.x && y == coordinate.y) {
                    return false
                }
            }

        }
        //TODO: board
        return true
    }
}
