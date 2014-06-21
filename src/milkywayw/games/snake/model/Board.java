package milkywayw.games.snake.model;

import milkywayw.utilities.Point;

public class Board
{
    private static final int DEFAULT_COLS = 40;
    private static final int DEFAULT_ROWS = 30;

    private int cols, rows;

    public Board()
    {
        this(DEFAULT_COLS, DEFAULT_ROWS);
    }

    public Board(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
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

    public int getNumRows()
    {
        return rows;
    }

    public int getNumCols()
    {
        return cols;
    }
}