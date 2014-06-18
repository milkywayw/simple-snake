package milkywayw.games.snake.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class SnakeRender extends JFrame
{
    private DrawBoard canvas;
    
    static final int CELL_SIZE = 20;

    private static final Color BOARD_COLOR = Color.gray;
    private static final Color SNAKE_COLOR = Color.green;
    private static final Color FOOD_COLOR = Color.cyan;
    
    public SnakeRender(int width, int height)
    {   
        initFrame();
        
        canvas = new DrawBoard(width, height); 
        add(canvas);
        
        finalizeFrame();
    }
    
    private void initFrame()
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");
    }
    
    private void finalizeFrame()
    {
        pack();
        setLocationRelativeTo(null); //center on screen
        setVisible(true);
    }
    
    public void update(Collection<Point> snake, Point food)
    {
        // reset the board, then color in the snake and food
        canvas.colorBoard(BOARD_COLOR);
        canvas.colorPoints(snake, SNAKE_COLOR);
        canvas.colorPoint(food, FOOD_COLOR);
        
        repaint();
    }
}