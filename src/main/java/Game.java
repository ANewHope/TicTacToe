import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {
  public static final int ROWS = 3;
  public static final int COLS = 3;
  public static final int CELL_SIZE = 100;
  
  private Board board;
  private CellContent currentPlayer;
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
