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

        setPreferredSize(new Dimension(cols * SnakeRender.CELL_SIZE, rows * SnakeRender.CELL_SIZE));
        setLayout(new GridLayout(rows, cols));
        initGrid(cols, rows);
    }

    private void initGrid(int cols, int rows)
    {
        grid = new ColorCell[cols][rows];

        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
            {
                grid[j][i] = new ColorCell();
                add(grid[j][i]);
            }
    }

    void colorBoard(Color color)
    {
        for (int j = 0; j < cols; ++j)
            for (int i = 0; i < rows; ++i)
                grid[j][i].setColor(color);
    }

    void colorPoints(Collection<Point> points, Color color)
    {
        for (Point p : points)
            colorPoint(p, color);
    }

    void colorPoint(Point point, Color color)
    {
        // rows-y-1 is because grid has 0,0 as top left corner while
        // point has 0,0 as bottom left corner.
        grid[point.getX()][rows - point.getY() - 1].setColor(color);
    }
}