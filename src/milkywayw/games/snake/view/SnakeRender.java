package milkywayw.games.snake.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import milkywayw.games.snake.model.Snake.Direction;
import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class SnakeRender extends JFrame
{
    private DrawBoard canvas;
    
    static final int CELL_SIZE = 20;

    private static final Color BOARD_COLOR = Color.gray;
    private static final Color SNAKE_COLOR = Color.green;
    private static final Color FOOD_COLOR = Color.cyan;
    
    private Direction lastPressed;
    
    public SnakeRender(int rows, int cols, Direction dir)
    {   
        initFrame();
        
        lastPressed = dir;
        canvas = new DrawBoard(rows, cols); 
        initKeyboardMap();
        
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
    
    public Direction getLastDirection()
    {
        return lastPressed;
    }
    
    public void update(Collection<Point> snake, Point food)
    {
        canvas.colorPoints(snake, SNAKE_COLOR);
        canvas.colorPoint(food, FOOD_COLOR);
        
        repaint();
    }
    
    private void initKeyboardMap()
    {
        Action setLeft = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setDirection(Direction.LEFT);
            }
        };
        
        Action setRight = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setDirection(Direction.RIGHT);   
            }
        };
        
        Action setUp = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setDirection(Direction.UP);   
            }
        };
        
        Action setDown = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setDirection(Direction.DOWN);   
            }
        };

        canvas.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
        
        canvas.getActionMap().put("up", setUp);        
        canvas.getActionMap().put("down", setDown);        
        canvas.getActionMap().put("left", setLeft);        
        canvas.getActionMap().put("right", setRight);
    }
    
    public void setDirection(Direction dir)
    {
        lastPressed = dir;
    }
}