package richardo.personal.games;

import java.util.HashSet;
import java.util.LinkedList;

import richardo.personal.games.utilities.Point;

public class Snake
{
	private LinkedList<Point> snake;
	private HashSet<Point> points;
	private Direction currDir;
	
	private enum Direction
	{	
		UP(new Point(0, 1)), RIGHT(new Point(1, 0)),
		DOWN(new Point(0, -1)), LEFT(new Point(-1,0));

		private Point delta;
		
		private Direction(Point delta) { this.delta = delta; }
		public Point getDelta() { return delta; }
	};
	
	public Snake(Point initialPoint, Direction dir)
	{
		snake = new LinkedList<Point>();
		points = new HashSet<Point>();
		
		currDir = dir;
		addHead(initialPoint);
	}
    
	public Direction getDir()
	{
		return currDir;
	}
    
	public void setDir(Direction dir)
	{
		currDir = dir;
	}
	
    public void move(Direction dir)
    {
    	removeTail();
        grow(dir);
    }
    
    public void grow()
    {
    	Point head = snake.getFirst();
        Point delta = currDir.getDelta();
        
        Point newHead = new Point(head.getX() + delta.getX(), head.getY() + delta.getY());
        
        addHead(newHead);
    }
    
    public void addHead(Point p)
    {
    	snake.addFirst(p);
    	points.add(p);
    }
    
    public void removeTail()
    {
    	points.remove(snake.removeLast());
    }
}
