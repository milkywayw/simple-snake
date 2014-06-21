package milkywayw.games.snake.controller;

import java.util.ArrayList;
import java.util.Random;

import milkywayw.games.snake.model.Board;
import milkywayw.games.snake.model.Direction;
import milkywayw.games.snake.model.Food;
import milkywayw.games.snake.model.Snake;
import milkywayw.utilities.Point;


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
            moveFood(board, snake, food);
        }
        else
        {
            snake.move();
        }    
    
        return true;
    }
    
    // board starts empty
    public static Snake generateSnake(Board board)
    {
        Point p;
        Direction dir;
        
        int x = rng.nextInt(board.getNumCols());
        int y = rng.nextInt(board.getNumRows());
        p = new Point(x,y);
        
        // point to furthest wall
        {
            int closestXWall = Math.min(board.getNumCols() - x, x);
            int closestYWall = Math.min(board.getNumRows() - y, y);    
        
            if(closestXWall < closestYWall)
            {
                dir = (board.getNumCols() - x > x) ? Direction.RIGHT : Direction.LEFT;
            }
            else
            {
                dir = (board.getNumRows() - y > y) ? Direction.UP : Direction.DOWN;
            }
        }
        
        return new Snake(p, dir);
    }
    
    public static Food generateFood(Board board, Snake snake)
    {   
        return new Food(findEmptyPoint(board, snake));   
    }
    
    public static void moveFood(Board board, Snake snake, Food food)
    {
        food.setLocation(findEmptyPoint(board, snake));
    }
    
    // assumes food is currently not on the board
    private static Point findEmptyPoint(Board board, Snake snake)
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
        
        return pool.get(rng.nextInt(pool.size()));
    }
}