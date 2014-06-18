package milkywayw.games.snake.view;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class SnakeRender extends JFrame
{
    private DrawBoard canvas;
 
    static final int CELL_SIZE = 20;
    
    public SnakeRender(int width, int height)
    {   
        initFrame();
        
        canvas = new DrawBoard(width, height); 
        add(canvas);
        
        pack();
    }
    
    private void initFrame()
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void update(Collection<Point> snake, int width, int height, Point food)
    {
        canvas.drawBoard();
        canvas.drawSnake(snake);
        canvas.drawFood(food);
        
        repaint();
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                SnakeRender snakeGame = new SnakeRender(5, 6);
                snakeGame.setVisible(true);
            }
        });
    }
}