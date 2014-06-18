package milkywayw.games.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import milkywayw.utilities.Point;

@SuppressWarnings("serial")
public class DrawBoard extends JPanel
{
    private ColorCell[][] grid;
    private int cols, rows;

    public DrawBoard(int cols, int rows)
    {
        this.cols = cols;
        this.rows = rows;

        setPreferredSize(new Dimension(cols * SnakeRender.CELL_SIZE, rows * SnakeRender.CELL_SIZE));
        setLayout(new GridLayout(rows, cols));

        initGrid(cols, rows);
    }

    private void initGrid(int cols, int rows)
    {
        grid = new ColorCell[rows][cols];

        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
            {
                grid[i][j] = new ColorCell();
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                add(grid[i][j]);
            }
    }

    void drawBoard()
    {
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                grid[i][j].setColor(Color.gray);
    }

    void drawSnake(Collection<Point> snake)
    {
        for (Point p : snake)
            grid[p.getX()][p.getY()].setColor(Color.green);
    }

    void drawFood(Point point)
    {
        grid[point.getX()][point.getY()].setColor(Color.cyan);
    }
}