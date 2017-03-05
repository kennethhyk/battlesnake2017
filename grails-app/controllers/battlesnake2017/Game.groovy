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

            state = 2

    }

    def Next(){
        //1: sleepy
        if (state == 1) {
            return Sleepy()
        }
        //2: food
        if (state == 2) {
          return findFood()
        }
        //3: escape
        if (state == 3) {

        }
    }
//findFood
    String findFood() {
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
        nextStep = new Coordinate(head.x, head.y)
        Coordinate food = foods.first()
        println(food.x)
        println(head.x)
        if(food.x > head.x) {
            nextStep.x = nextStep.x + 1
            return head.directionTo(nextStep)
        }
        if(food.x < head.x) {
            if(food.y > head.y) {
                nextStep.y = nextStep.y + 1
                return head.directionTo(nextStep)
            }
        }
        if(food.y > head.y) {
            nextStep.y = nextStep.y + 1
            return head.directionTo(nextStep)
        }
        if(food.y < head.y) {
            nextStep.y = nextStep.y - 1
            return head.directionTo(nextStep)
        }

        return head.directionTo(nextStep)
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
        if(squareList.size() == 0) {
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
//        if(isSafe(nextStep.x, nextStep.y)) {
//        }
        return head.directionTo(nextStep)
//        else {
//            if(isSafe(head.x, head.y-1)){
//                return head.directionTo(new Coordinate(head.x, head.y-1))
//            }
//            if(isSafe(head.x, head.y+1)){
//                return head.directionTo(new Coordinate(head.x, head.y+1))
//            }
//            if(isSafe(head.x-1, head.y)){
//                return head.directionTo(new Coordinate(head.x-1, head.y))
//            }
//            if(isSafe(head.x+1, head.y)){
//                return head.directionTo(new Coordinate(head.x+1, head.y))
//            }
//        }
    }

    boolean isSafe(int x,int y){
        for(Snake snake in snakes){
            for(Coordinate coordinate in snake.coords) {
                if (x == coordinate.x && y == coordinate.y) {
                    return false
                }
            }
        }
        if(x == width-1 || y == height-1 || x == -1 || y == -1) {
            return false
        }
        return true
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

    List<Coordinate> radiation(List<Coordinate> list) {
        List<Coordinate> coordinateList = []
        for(Coordinate coords in list){
            if(list.find{it.x == coords.x && it.y == coords.y-1}){
                coordinateList.add(new Coordinate(coords.x, coords.y-1))
            }
            if(list.find{it.x == coords.x && it.y == coords.y+1}){
                coordinateList.add(new Coordinate(coords.x, coords.y+1))
            }
            if(list.find{it.x == coords.x-1 && it.y == coords.y}){
                coordinateList.add(new Coordinate(coords.x-1, coords.y))
            }
            if(list.find{it.x == coords.x+1 && it.y == coords.y}){
                coordinateList.add(new Coordinate(coords.x+1, coords.y))
            }
        }
        return coordinateList
    }
}


