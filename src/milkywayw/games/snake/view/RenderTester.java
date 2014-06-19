package milkywayw.games.snake.view;

import java.util.ArrayList;

import milkywayw.utilities.Point;

public class RenderTester
{
    private static ArrayList<Point> generateSnake()
    {
        ArrayList<Point> snake = new ArrayList<>();

        for (int i = 2; i <= 18; ++i)
            snake.add(new Point(i, 4));

        for (int j = 4; j <= 20; j++)
            snake.add(new Point(2, j));

        snake.add(new Point(3, 20));

        return snake;
    }

    private static Point generateFood()
    {
        return new Point(27, 37);
    }
}
