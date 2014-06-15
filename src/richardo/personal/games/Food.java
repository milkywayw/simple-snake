package richardo.personal.games;

import richardo.personal.games.utilities.Point;

public class Food
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
}
