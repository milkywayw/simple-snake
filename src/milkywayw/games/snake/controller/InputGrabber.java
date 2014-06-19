package milkywayw.games.snake.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import milkywayw.games.snake.model.Snake.Direction;
import milkywayw.games.snake.view.DrawBoard;

@SuppressWarnings("serial")
public class InputGrabber
{
    private Direction lastPressed;
    
    private boolean resetFlag = false;
    
    public InputGrabber(DrawBoard canvas)
    {
        wireControllerToView(canvas);
    }
    
    public void setDirection(Direction dir)
    {
        lastPressed = dir;
    }
    
    public boolean resetFlagIsSet()
    {
        return resetFlag;
    }
    
    public void clearResetFlag()
    {
        resetFlag = false;
    }
    
    public Direction getLastDirection()
    {
        return lastPressed;
    }
    
    private void wireControllerToView(DrawBoard canvas)
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

        canvas.setFocusable(true);
        
        canvas.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
        canvas.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
        
        canvas.getActionMap().put("up", setUp);        
        canvas.getActionMap().put("down", setDown);        
        canvas.getActionMap().put("left", setLeft);        
        canvas.getActionMap().put("right", setRight); 
        
        canvas.requestFocus();
    }
}
