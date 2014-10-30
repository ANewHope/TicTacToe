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
  public boolean checkTie() {
    if(checkWin()) return false;
    for(int r = 0; r < Game.ROWS; r++) {
      for(int c = 0; c < Game.COLS; c++) {
        if(cell[r][c].content == CellContent.EMPTY) {
          return false;
        }
      }
    }
    return true;
  }
  public boolean checkWin() {
    return (checkRows() || checkCols() || checkDiags());
  }
  public void paint(Graphics G) {
    return;
  }

  private boolean checkRows() {
    for(int i = 0; i < 3; i++) {
      if((cell[i][0].content == cell[i][1].content) && (cell[i][0].content == cell[i][2].content) && cell[i][0].content != CellContent.EMPTY) {
        return true;
      }
    }
    return false;
  }
  private boolean checkCols() {
    for(int i = 0; i < 3; i++) {
      if((cell[0][i].content == cell[1][i].content) && (cell[0][i].content == cell[2][i].content) && cell[0][i].content != CellContent.EMPTY) {
        return true;
      }
    }
    return false;
  }
  private boolean checkDiags() {
    if((cell[0][0].content == cell[1][1].content) && (cell[0][0].content == cell[2][2].content) && cell[0][0].content != CellContent.EMPTY) {
      return true;
    }
    else if((cell[2][0].content == cell[1][1].content) && (cell[2][0].content == cell[0][2].content) && cell[2][0].content != CellContent.EMPTY) {
      return true;
    }
    return false;
  }
}
