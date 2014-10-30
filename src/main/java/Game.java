import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {
  public static final int ROWS = 3;
  public static final int COLS = 3;
  public static final int CELL_SIZE = 150;
  public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
  public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
  public static final int GRID_WIDTH = 10;
  
  private Board board;
  private State currState;
  private CellContent currPlayer;
  private JLabel statusBar;

  public Game() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
      }
    });
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(Color.WHITE);
    board.paint(g);
    switch(currState) {
      case IN_PROGRESS:
        statusBar.setForeground(Color.BLACK);
        if(currPlayer == CellContent.ZERO) {
          statusBar.setText("O á leik");
        }
        else {
          statusBar.setText("X a leik");
        }
        break;
      case TIE:
        statusBar.setForeground(Color.BLUE);
        statusBar.setText("Jafntefli!!!!"); 
        break;
      case EX_WON:
        statusBar.setForeground(Color.GREEN);
        statusBar.setText("X vann! Yei. Má bjóða ykkur að spila aftur?");
        break;
      case ZERO_WON:
        statusBar.setForeground(Color.RED);
        statusBar.setText("O vann! Neiiiiiii. ???");
        break;
    }
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setContentPane(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }
}
