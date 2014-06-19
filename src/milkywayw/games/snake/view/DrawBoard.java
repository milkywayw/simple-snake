package milkywayw.games.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class DrawBoard extends JPanel
{
    private ArrayList<ColorCell> pixels;
    private int cols, rows;
    
    private final static Color DEFAULT_COLOR = Color.gray;

    public DrawBoard(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        setPreferredSize(new Dimension(cols * SnakeRender.CELL_SIZE, rows * SnakeRender.CELL_SIZE));
        setOpaque(true);
        
        pixels = new ArrayList<ColorCell>();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        int cellHeight = getHeight() / rows;
        int cellWidth = getWidth() / cols;
        
        g.setColor(DEFAULT_COLOR);
        
        g.fillRect(0, 0, getWidth(), getHeight());  // clear board
        drawPixels(g, cellWidth, cellHeight);
        drawGridLines(g, cellWidth, cellHeight);
    }
    
    private void drawPixels(Graphics g, int cellWidth, int cellHeight)
    {
        for(ColorCell pixel : pixels)
        {
            g.setColor(pixel.getColor());
            int col = pixel.getCoord().getX();
            int row = rows - pixel.getCoord().getY() - 1;
            
            g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
        }
    }

    private void drawGridLines(Graphics g, int cellWidth, int cellHeight)
    {
        g.setColor(Color.black);
        
        for(int row = 0; row < rows; ++row)
        {
            g.drawLine(0, row * cellHeight, getWidth(), row * cellHeight);
        }
        
        for(int col = 0; col < cols; ++col)
        {
            g.drawLine(col * cellWidth, 0, col * cellWidth, getHeight());
        }
    }

    public void reset()
    {
        pixels.clear();
    }
    
    void colorPoints(Collection<Point> points, Color color)
    {
        for (Point p : points)
            colorPoint(p, color);
    }

    void colorPoint(Point point, Color color)
    {
        pixels.add(new ColorCell(point, color));
    }
}