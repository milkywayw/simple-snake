package milkywayw.games.snake.controller;

import java.awt.event.ActionEvent;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import milkywayw.games.snake.view.PixelBoard;
import milkywayw.utilities.Direction;

@SuppressWarnings("serial")
public class InputGrabber
{
	private static final int BUFFER_SIZE = 2;

	private Deque<Direction> inputBuffer;
    
    private boolean resetFlag = false;
    
    public InputGrabber(PixelBoard canvas)
    {
    	inputBuffer = new LinkedList<>();
        wireControllerToView(canvas);
    }
    
    public void setDirection(Direction dir)
    {
    	inputBuffer.addFirst(dir);
    	
        if(inputBuffer.size() > BUFFER_SIZE)
        	inputBuffer.removeLast();
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
        return (inputBuffer.isEmpty()) ? null : inputBuffer.removeLast();
    }
    
    private void wireControllerToView(PixelBoard canvas)
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
