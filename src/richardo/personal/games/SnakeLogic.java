package richardo.personal.games;

import java.util.ArrayList;
import java.util.Random;

import richardo.personal.games.utilities.Point;

public class SnakeLogic
{
    static Random rng = new Random();
    
    // return whether snake is alive
    public static boolean update(Snake snake, Food food, Board board)
    {   
        Point target = snake.nextPoint();
        
        if(snake.containsPoint(target) || ! board.withinBounds(target))
        {
            return false;
        }
 
        if(food.getLocation().equals(target))
        {
            snake.grow();
            generateNextFood(snake, food, board);
        }
        else
        {
            snake.move();
        }    
    
        return true;
    }
    
    /*
    private static void _generateNextFood(Snake snake, Food food, Board board)
    {
        do
        {
            food.setLocation(new Point(rng.nextInt(board.getWidth()), rng.nextInt(board.getHeight())));
        }
        while(snake.containsPoint(food.getLocation()));
    }
    */
    
    private static void generateNextFood(Snake snake, Food food, Board board)
    {   
        ArrayList<Point> pool = new ArrayList<>(board.getNumCols() * board.getNumRows());
        
        for(int i = 0; i < board.getNumCols(); ++i)
        {
            for(int j = 0; j < board.getNumRows(); ++j)
            {
                Point p = new Point(i, j);
                
                if(snake.containsPoint(p))
                    continue;
                
                pool.add(p);
            }
        }
        
        food.setLocation(pool.get(rng.nextInt(pool.size())));   
    }
}