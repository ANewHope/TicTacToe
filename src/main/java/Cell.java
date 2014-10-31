import java.awt.*;

public class Cell {
  CellContent content;
  int row, col;
  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    content = CellContent.EMPTY;
  }
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setStroke(new BasicStroke(Game.SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    int x1 = col * Game.CELL_SIZE + Game.CELL_PADDING;
    int y1 = row * Game.CELL_SIZE + Game.CELL_PADDING;
    if(content == CellContent.ZERO) {
      g2d.setColor(Color.BLUE);
      g2d.drawOval(x1, y1, Game.SYMBOL_SIZE, Game.SYMBOL_SIZE);
    }
    else if(content == CellContent.EX) {
      g2d.setColor(Color.RED);
      int x2 = (col + 1) * Game.CELL_SIZE - Game.CELL_PADDING;
      int y2 = (row + 1) * Game.CELL_SIZE - Game.CELL_PADDING;
      g2d.drawLine(x1,y1,x2,y2);
      g2d.drawLine(x2,y1,x1,y2);
    }
  }
}
