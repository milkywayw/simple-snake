package milkywayw.games.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JPanel;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class DrawBoard extends JPanel
{
    private ColorCell[][] grid;
    private int cols, rows;

    public DrawBoard(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        setPreferredSize(new Dimension(rows * SnakeRender.CELL_SIZE, cols * SnakeRender.CELL_SIZE));
        setLayout(new GridLayout(cols, rows));

        initGrid(cols, rows);
    }

    private void initGrid(int cols, int rows)
    {
        grid = new ColorCell[cols][rows];

        for (int j = 0; j < cols; ++j)
            for (int i = 0; i < rows; ++i)
            {
                grid[j][i] = new ColorCell();
                add(grid[j][i]);
            }
    }

    void colorBoard(Color color)
    {
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                grid[j][i].setColor(color);
    }

    void colorPoints(Collection<Point> points, Color color)
    {
        for (Point p : points)
            colorPoint(p, color);
    }

    void colorPoint(Point point, Color color)
    {
        grid[point.getX()][point.getY()].setColor(color);
    }
}