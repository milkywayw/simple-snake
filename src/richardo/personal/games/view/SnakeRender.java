package richardo.personal.games.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SnakeRender
{
    private JFrame frame;
    private JPanel board;
    private JLabel title;
    
    private static final boolean DOUBLE_BUFFERED = true;
    private static final long serialVersionUID = 1L;

    public SnakeRender()
    {
        initFrame();
        initPanel();
        initLabel();
        
        frame.add(board, BorderLayout.CENTER);
        frame.add(title, BorderLayout.NORTH);
    }
    
    private void initFrame()
    {
        frame = new JFrame();
        
        frame.setTitle("Snake");
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new BorderLayout());
    }
    
    private void initPanel()
    {
        board = new JPanel(DOUBLE_BUFFERED);
        
        board.setBackground(Color.red);
        board.setPreferredSize(new Dimension(400,400));
    }
    
    private void initLabel()
    {
        title = new JLabel("Snake!");

        title.setBackground(Color.black);
        title.setForeground(Color.white);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                SnakeRender snakeGame = new SnakeRender();
                snakeGame.frame.setVisible(true);
            }
        });
    }
}
