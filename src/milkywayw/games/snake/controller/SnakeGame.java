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
    
    // controller
    private InputGrabber input;
    
    private final static int DEFAULT_ROWS = 30;
    private final static int DEFAULT_COLS = 40;
    
    // milliseconds - 60 FPS
    private final static double STEP_SIZE = 100;
    
    
    public SnakeGame()
    {
        this(DEFAULT_COLS, DEFAULT_ROWS);
    }
    
    //possibility for command line args
    public SnakeGame(int cols, int rows)
    {
        // view
        window = new SnakeRender(rows, cols);

        // controller (?)
        // TODO: make an interface for drawboard, then use that interface
        input = new InputGrabber(window.getCanvas());
        
        initializeGame(cols, rows);
        runGame();
    }
    
    private void initializeGame(int cols, int rows)
    {
        // model
        board = new Board(rows, cols);
        snake = SnakeLogic.generateSnake(board);
        food = SnakeLogic.generateFood(board, snake);
    }
    
    // main loop goes here
    private void runGame()
    {
        boolean alive = true;
        double lastTime = System.currentTimeMillis();

        while(alive)
        {
            double thisTime = System.currentTimeMillis();
           
            
            if((thisTime - lastTime) < STEP_SIZE)
                continue;
            else 
            	lastTime = thisTime;
           
            // INPUT
            snake.setDirection(input.getLastDirection());          
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