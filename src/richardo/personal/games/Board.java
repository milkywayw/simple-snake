package richardo.personal.games;

import richardo.personal.games.utilities.Point;

public class Board
{
	private static final int DEFAULT_WIDTH = 40;
	private static final int DEFAULT_HEIGHT = 30;
	
	private int width, height;
	
	public Board()
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	private boolean withinBounds(Point p)
	{
		int x = p.getX();
		int y = p.getY();
		
		if(x < 0 || y < 0)
			return false;
		
		if(x >= width || y >= height)
			return false;
		
		return true;
	}
}