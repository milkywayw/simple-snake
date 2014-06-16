package milkywayw.games.snake.model;

import milkywayw.utilities.Point;

public class Board
{
    private static final int DEFAULT_WIDTH = 40;
    private static final int DEFAULT_HEIGHT = 30;

    private int cols, rows;

    public Board()
    {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Board(int cols, int rows)
    {
        this.cols = cols;
        this.rows = rows;
    }

    public boolean withinBounds(Point p)
    {
        int x = p.getX();
        int y = p.getY();

        if (x < 0 || y < 0)
            return false;

        if (x >= cols || y >= rows)
            return false;

        return true;
    }
    
    public int getNumCols()
    {
        return cols;
    }
    
    public int getNumRows()
    {
        return rows;
    }
}