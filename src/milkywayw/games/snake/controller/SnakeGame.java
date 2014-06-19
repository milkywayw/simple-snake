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
    
    private final static int DEFAULT_ROWS = 30;
    private final static int DEFAULT_COLS = 40;
    
    
    public SnakeGame()
    {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }
    
    //possibility for command line args
    public SnakeGame(int rows, int cols)
    {
        initializeGame(rows, cols);
        runGame();
        // reset game or something here
    }
    
    private void initializeGame(int rows, int cols)
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
        // INPUT
        // TODO: update snake's direction if key is pressed
        // PROCESS
        SnakeLogic.update(snake,food,board);
        // RENDER
        window.update(snake.getPoints(),food.getLocation());
    }
    
    public static void main(String[] args)
    {
        new SnakeGame();
    }
}