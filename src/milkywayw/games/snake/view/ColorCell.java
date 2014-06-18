package milkywayw.games.snake.view;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ColorCell extends JLabel
{   
    public ColorCell()
    {
        setBackground(Color.gray);
        setOpaque(true);
    }
    
    public void setColor(Color color)
    {
        setBackground(color);
    }
}
