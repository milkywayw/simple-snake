package milkywayw.games.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class PixelBoard extends JPanel
{
    private ArrayList<Pixel> pixels;
    private int cols, rows;
    private Color defaultColor;

    public PixelBoard(Color color, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        defaultColor = color;

        setPreferredSize(new Dimension(cols * SnakeRender.CELL_SIZE, rows * SnakeRender.CELL_SIZE));
        setOpaque(true);
        setBackground(Color.black);

        pixels = new ArrayList<Pixel>();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // doubles to prevent rounding error and warping on screen resize
        double cellHeight = (double) getHeight() / rows;
        double cellWidth = (double) getWidth() / cols;

        // clear currently drawn pixels
        g.setColor(defaultColor);
        g.fillRect(0, 0, (int) (cols * cellWidth), (int) (rows * cellHeight));

        // draw the new pixels
        drawPixels(g, cellWidth, cellHeight);
        drawGridLines(g, cellWidth, cellHeight);
    }

    private void drawPixels(Graphics g, double cellWidth, double cellHeight)
    {
        for (Pixel pixel : pixels)
        {
            g.setColor(pixel.getColor());
            int col = pixel.getCoord().getX();
            int row = rows - pixel.getCoord().getY() - 1;

            g.fillRect((int) (col * cellWidth), (int) (row * cellHeight), (int) cellWidth,
                    (int) cellHeight);
        }
    }

    private void drawGridLines(Graphics g, double cellWidth, double cellHeight)
    {
        g.setColor(Color.black);

        for (int row = 0; row < rows; ++row)
            g.drawLine(0, (int) (row * cellHeight), getWidth(), (int) (row * cellHeight));

        for (int col = 0; col < cols; ++col)
            g.drawLine((int) (col * cellWidth), 0, (int) (col * cellWidth), getHeight());
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
        pixels.add(new Pixel(point, color));
    }
}