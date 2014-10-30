import java.awt.*;

public class Cell {
  CellContent content;
  int row, col;
  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    content = CellContent.EMPTY;
  }
  public void drawCell(Graphics g) {
    
  }
}
