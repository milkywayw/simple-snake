package milkywayw.games.snake.model;

import java.util.HashSet;
import java.util.LinkedList;

import milkywayw.utilities.Point;


public class Snake
{
    private LinkedList<Point> snake;
    private HashSet<Point> points;
    private Direction currDir;

    public static enum Direction
    {
        UP(new Point(0, 1)), RIGHT(new Point(1, 0)), DOWN(new Point(0, -1)), LEFT(new Point(-1, 0));

        private Point delta;

        private Direction(Point delta)
        {
            this.delta = delta;
        }

        public Point getDelta()
        {
            return delta;
        }
        
        public boolean isPerpendicular(Direction other)
        {
            // dot product
            int i1 = delta.getX();
            int i2 = delta.getY();
            
            int j1 = other.delta.getX();
            int j2 = other.delta.getY();
            
            return i1 * j1 + i2 * j2 == 0;
        }
    }

    public Snake(Point initialPoint, Direction dir)
    {
        snake = new LinkedList<Point>();
        points = new HashSet<Point>();

        currDir = dir;
        addHead(initialPoint);
    }

    public Direction getDirection()
    {
        return currDir;
    }

    public void setDirection(Direction dir)
    {
        if(dir == null)
            return;
                    
        if(dir.isPerpendicular(currDir))
            currDir = dir;
    }

    public boolean containsPoint(Point point)
    {
        return points.contains(point);
    }
    
    public Point getHead()
    {
        return snake.getFirst();
    }
    
    public void move()
    {
        grow();
        removeTail();
    }

    public void grow()
    {
        Point target = nextPoint();
        addHead(target);
    }
    
    public Point nextPoint()
    {
        Point head = snake.peekFirst();
        Point delta = currDir.getDelta();

        return new Point(head.getX() + delta.getX(), head.getY() + delta.getY());
    }

    private void addHead(Point p)
    {
        snake.addFirst(p);
        points.add(p);
    }

    private void removeTail()
    {
        points.remove(snake.removeLast());
    }
    
    public HashSet<Point> getPoints()
    {
        return new HashSet<Point>(points);
    }
}
