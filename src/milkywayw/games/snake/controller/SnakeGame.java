package milkywayw.games.snake.controller;

import milkywayw.games.snake.model.Board;
import milkywayw.games.snake.model.Food;
import milkywayw.games.snake.model.Snake;
import milkywayw.games.snake.view.SnakeRender;

public class SnakeGame
{   
    // models
    private Snake snake;
    private Board board;
    private Food food;
    
    // view
    private SnakeRender window;
    
    private final static int DEFAULT_ROWS = 20;
    private final static int DEFAULT_COLS = 30;
    
    // milliseconds
    private final static int STEP_SIZE = 300;
    
    
    public SnakeGame()
    {
        this(DEFAULT_COLS, DEFAULT_ROWS);
    }
    
    //possibility for command line args
    public SnakeGame(int cols, int rows)
    {
        initializeGame(cols, rows);
        runGame();
        // reset game or something here
    }
    
    private void initializeGame(int cols, int rows)
    {
        // model
        board = new Board(rows, cols);
        snake = SnakeLogic.generateSnake(board);
        food = SnakeLogic.generateFood(board, snake);
        
        // view
        window = new SnakeRender(rows, cols);
        
        // controller
        /* controller class initialization? */
    }
    
    // main loop goes here
    private void runGame()
    {
        boolean alive = true;
        double lastTime = System.currentTimeMillis();
        snake.grow();snake.grow();snake.grow();
        
        while(alive)
        {
            double thisTime = System.currentTimeMillis();
            
            if((thisTime - lastTime) < STEP_SIZE)
                continue;

            lastTime = thisTime;
            
            // INPUT
            // TODO: update snake's direction if key is pressed
            // PROCESS
            alive = SnakeLogic.update(snake,food,board);
            // RENDER
            window.update(snake.getPoints(),food.getLocation());   
        }
    }
    
    public static void main(String[] args)
    {
        new SnakeGame();
    }
}