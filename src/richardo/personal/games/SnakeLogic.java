package richardo.personal.games;

import java.util.Random;

import richardo.personal.games.utilities.Point;
import richardo.personal.games.Board;
import richardo.personal.games.Food;
import richardo.personal.games.Snake;

public class SnakeLogic
{
    // return whether snake is alive
    public boolean update(Snake snake, Food food, Board board)
    {
        Point head = snake.getHead();
        Point delta = snake.getDir().delta;
        
        Point target = new Point(head.getX() + delta.getX(), head.getY() + delta.getY());
        
        if(snake.containsPoint(target) || ! board.withinBounds(target))
        {
            return false;
        }
 
        if(food.getLocation().equals(target))
        {
            snake.grow();
            Random rng = new Random(); // probably move this somewhere as we don't really need a new RNG everytime food is eaten.
            do
            {
                food.setLocation(new Point(rng.nextInt(board.getWidth()),rng.nextInt(board.getHeight())));
            }
            while(snake.containsPoint(food.getLocation()));
        }
        else
        {
            snake.move();
        }    
    
        return true;
    }
}