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
    List<Coordinate> squareList
    Snake mySnake
    Heatmap heatmap



    final List<Snake> getSnakes() {
        return snakes
    }

    def computeState() {

        if(mySnake.health_points < 35) {
            state = 2
        }

    }

    def Next(){
        //1: sleepy
        if (state == 1) {
            return Sleepy()
        }
        //2: food
        if (state == 2) {
//
        }
        //3: escape
        if (state == 3) {

        }
    }

//sleepy
    String Sleepy(){
        Coordinate head
        Coordinate nextStep
        for(Snake snake in snakes)
        {
            if(you == snake.id)
            {
                mySnake = snake
            }
        }
        head = mySnake.coords[0]
        //todo: clear squareList once exit remove all items
        if(squareList.size() == 0){
            int ceilling = Math.ceil(mySnake.coords.size()/4)
            if(mySnake.coords[1].x > head.x){
                squareList = cWise(head,ceilling)

            }else{
                squareList = clockWise(head, ceilling)
            }
        }
        for(int i = 0; i < squareList.size(); i++){
            if(squareList[i].x == head.x && squareList[i].y == head.y){
                if(i == squareList.size()-1) {
                    nextStep = squareList[0]
                    break
                }
                nextStep = squareList[i+1]
                break
            }
        }
        return head.directionTo(nextStep)
    }



    List<Coordinate> cWise(Coordinate head,int length) {
        Coordinate ref = head
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x, ref.y - i)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x + i, ref.y)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x, ref.y + i)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x - i, ref.y)
            squareList.add(ref)
        }

        return squareList
    }
    List<Coordinate> clockWise(Coordinate head,int length) {
        Coordinate ref = head
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x+i, ref.y)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x, ref.y-i)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x-i, ref.y)
            squareList.add(ref)
        }
        for (int i = 1; i <= length; i++) {
            ref = new Coordinate(ref.x, ref.y+i)
            squareList.add(ref)
        }

        return squareList
    }
}


