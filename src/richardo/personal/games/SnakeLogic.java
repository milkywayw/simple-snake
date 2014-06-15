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
        // calling this directly means nextPoint's logic gets executed twice. not a huge deal, but i wonder if there's a better way
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
    
    private static void generateNextFood(Snake snake, Food food, Board board)
    {
        do
        {
            food.setLocation(new Point(rng.nextInt(board.getWidth()), rng.nextInt(board.getHeight())));
        }
        while(snake.containsPoint(food.getLocation()));
    }
    
    // proposed alternate algorithm. although it's clunkier and probably slower for the beginning, it guarantees
    // that an available point will be chosen on the first try. worrisome if board is huge
    private static void _generateNextFood(Snake snake, Food food, Board board)
    {   
        ArrayList<Point> pool = new ArrayList<>(board.getHeight() * board.getWidth());
        
        for(int i = 0; i < board.getWidth(); ++i)
        {
            for(int j = 0; j < board.getHeight(); ++j)
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