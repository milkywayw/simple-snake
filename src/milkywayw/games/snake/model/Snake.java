package milkywayw.games.snake.model;

import java.util.HashSet;
import java.util.LinkedList;

import milkywayw.utilities.Direction;
import milkywayw.utilities.Point;

public class Snake
{
    private LinkedList<Point> snake;
    private HashSet<Point> points;
    private Direction currDir;

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
        if (dir == null)
            return;

        if (dir.isPerpendicular(currDir))
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

    public void translate()
    {
        extend();
        removeTail();
    }

    public void extend()
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
