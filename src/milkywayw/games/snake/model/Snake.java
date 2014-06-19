package milkywayw.games.snake.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;

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
