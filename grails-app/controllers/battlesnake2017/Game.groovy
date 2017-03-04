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


    final List<Snake> getSnakes() {
        return snakes
    }

    def Next(){
        if (state == 1) {
            return Sleepy()
        }
    }
    String Sleepy(){
        Coordinate head
        Coordinate nextStep
        Snake mySnake = null
        for(Snake snake in snakes)
        {
            if(you == snake.id)
            {
                mySnake = snake
            }
        }
        head = mySnake.coords[0]
        println(head)
        //todo: clear squareList once exit remove all items
        if(squareList.size() == 0){
            int ceilling = Math.ceil(mySnake.coords.size()/4)
            if(mySnake.coords[1].x > head.x){
                squareList = cWise(head,ceilling)

            }else{
                squareList = clockWise(head, ceilling)
            }
        }
        println('squarelist:'+ squareList)
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
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x, y:head.y - i))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x + i, y:head.y))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x, y:head.y + i))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x - i, y:head.y))
        }

        return squareList
    }
    List<Coordinate> clockWise(Coordinate head,int length) {
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x+i, y:head.y))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x, y:head.y-i))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x-i, y:head.y))
        }
        for (int i = 1; i <= length; i++) {
            squareList.add(new Coordinate(x:head.x, y:head.y+i))
        }

        return squareList
    }
}


