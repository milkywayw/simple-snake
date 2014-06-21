package milkywayw.utilities;

public enum Direction
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