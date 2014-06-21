package milkywayw.games.snake.view;

import java.awt.Color;

import milkywayw.utilities.Point;

public class Pixel
{
    private Point coord;
    private Color color;

    public Pixel(Point coord, Color color)
    {
        this.coord = coord;
        this.color = color;
    }

    public Point getCoord()
    {
        return coord;
    }

    public Color getColor()
    {
        return color;
    }
}
