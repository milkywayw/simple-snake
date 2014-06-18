package milkywayw.games.snake.model;

import java.util.Observable;

import milkywayw.utilities.Point;

public class Food extends Observable
{
    private Point location;
    
    public Food(Point coord)
    {
        location = coord;
    }
    
    public Point getLocation()
    {
        return location;
    }
    
    public void setLocation(Point point)
    {
        location = point;
    }
}
