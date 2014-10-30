public class Game extends Jpanel {
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
    }
  }

}
