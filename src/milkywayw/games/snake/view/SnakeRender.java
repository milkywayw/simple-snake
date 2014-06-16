package milkywayw.games.snake.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import milkywayw.games.snake.model.Board;
import milkywayw.games.snake.model.Food;
import milkywayw.games.snake.model.Snake;


public class SnakeRender extends JFrame
{
    private SnakeBoard canvas;
    private JLabel title;
    
    private static final long serialVersionUID = 1L;
    
    public SnakeRender()
    {
        initPanel();
        initLabel();
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(canvas, BorderLayout.CENTER);
        pane.add(title, BorderLayout.PAGE_END); 

        initFrame();
    }
    
    private void initFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initPanel()
    {
        canvas = new SnakeBoard();
    }
    
    private void initLabel()
    {
        title = new JLabel("Snake!");
        
        title.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        title.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        
        title.setOpaque(true);
        title.setBackground(Color.cyan);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                SnakeRender snakeGame = new SnakeRender();
                snakeGame.setVisible(true);
            }
        });
    }
    
    public void update(Snake snake, Food food, Board board)
    {
        drawBoard(board);
        drawSnake(snake);
        drawFood(food);
    }
    
    private void drawBoard(Board board)
    {
        canvas.repaint();
    }
    
    private void drawSnake(Snake snake)
    {
    
    }
    
    private void drawFood(Food food)
    {
    
    }
}