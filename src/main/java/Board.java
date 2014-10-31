import java.awt.*;

public class Board {
  Cell[][] cell;
  public Board() {
    int rows = Game.ROWS;
    int cols = Game.COLS;
    cell = new Cell[rows][cols];
    for(int r = 0; r < rows; r++) {
      for(int c = 0; c < cols; c++) {
        cell[r][c] = new Cell(r,c);
      }
    }
  }
  
  public void init() {
    for(int r = 0; r < Game.ROWS; r++) {
      for(int c = 0; c < Game.COLS; c++) {
        cell[r][c].content = CellContent.EMPTY;
      }
    }
  }
  public boolean checkTie() {
    if(checkWin(CellContent.EX) || checkWin(CellContent.ZERO)) return false;
    for(int r = 0; r < Game.ROWS; r++) {
      for(int c = 0; c < Game.COLS; c++) {
        if(cell[r][c].content == CellContent.EMPTY) {
          return false;
        }
      }
    }
    return true;
  }
  public boolean checkWin(CellContent c) {
    return (checkRows(c) || checkCols(c) || checkDiags(c));
  }
  public void paint(Graphics g) {
    g.setColor(Color.GRAY);
    for(int r = 1; r < Game.ROWS; r++) {
      g.fillRoundRect(0, Game.CELL_SIZE * r - Game.GRID_WIDTH_HALF, Game.CANVAS_WIDTH - 1, Game.GRID_WIDTH, Game.GRID_WIDTH, Game.GRID_WIDTH);
    }
    for(int c = 1; c < Game.COLS; c++) {
      g.fillRoundRect(Game.CELL_SIZE * c - Game.GRID_WIDTH_HALF, 0, Game.GRID_WIDTH, Game.CANVAS_HEIGHT - 1, Game.GRID_WIDTH, Game.GRID_WIDTH);
    }
    for(int r = 0; r < Game.ROWS; r++) {
      for(int c = 0; c < Game.COLS; c++) {
        cell[r][c].paint(g);
      }
    }
  }

  private boolean checkRows(CellContent c) {
    for(int i = 0; i < 3; i++) {
      if((cell[i][0].content == cell[i][1].content) && (cell[i][0].content == cell[i][2].content) && cell[i][0].content == c) {
        return true;
      }
    }
    return false;
  }
  private boolean checkCols(CellContent c) {
    for(int i = 0; i < 3; i++) {
      if((cell[0][i].content == cell[1][i].content) && (cell[0][i].content == cell[2][i].content) && cell[0][i].content == c) {
        return true;
      }
    }
    return false;
  }
  private boolean checkDiags(CellContent c) {
    if((cell[0][0].content == cell[1][1].content) && (cell[0][0].content == cell[2][2].content) && cell[0][0].content == c) {
      return true;
    }
    else if((cell[2][0].content == cell[1][1].content) && (cell[2][0].content == cell[0][2].content) && cell[2][0].content == c) {
      return true;
    }
    return false;
  }
}
