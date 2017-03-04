package battlesnake2017

/**
 * Created by kenneth on 2017-03-02.
 */
class Coordinate {
    int x
    int y
    Double heat

    Coordinate(int x, int y) {
        this.x = x
        this.y = y
        this.heat = 0.0
    }

    String toString() {
        return "("+x+ "," +y+")"
    }

    boolean isSafe(int x,int y){
        Game lizheng = new Game()
        List<Snake> snakes = lizheng.getSnakes()
        for(Snake snake in snakes){
            for(Coordinate coordinate in snake.coords) {
                if (x == coordinate.x && y == coordinate.y) {
                    return false
                }
            }

        }
        //TODO: board
        return true
    }

    String directionTo(Coordinate coords) {
        if(coords.x == x && coords.y == y-1){
            return "up"
        }
        if(coords.x == x && coords.y == y+1){
            return "down"
        }
        if(coords.x == x-1 && coords.y == y){
            return "left"
        }
        if(coords.x == x+1 && coords.y == y){
            return "right"
        }
    }
}
