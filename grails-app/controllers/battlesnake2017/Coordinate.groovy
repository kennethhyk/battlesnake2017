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
        this.heat = 0.5
    }

    String toString() {
        return "("+x+ "," +y+")"
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
