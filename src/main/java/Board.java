public class Board {
  Cell[][] cell;
  public Content winner;
  public static final int ROWS = 3;
  public static final int COLS = 3;

  public Board() {
    winner = Content.EMPTY;
    int rows = ROWS;
    int cols = COLS;
    cell = new Cell[rows][cols];
    for(int r = 0; r < rows; r++) {
      for(int c = 0;  c < cols; c++) {
        cell[r][c] = new Cell();
      }
    }
  }

  public void init() {
    winner = Content.EMPTY;
    for(int r = 0; r < ROWS; r++) {
      for(int c = 0; c < COLS; c++) {
        cell[r][c].content = Content.EMPTY;
      }
    }
  }

  public boolean checkTie() {
    if(checkWin()) return false;
    for(int r = 0; r < ROWS; r++) {
      for(int c = 0; c < COLS; c++) {
        if(cell[r][c].content == Content.EMPTY) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean checkWin() {
    Content x = Content.EX;
    Content o = Content.ZERO;
    if(checkRows(x) || checkCols(x) || checkDiags(x)) {
      winner = x;
      return true;
    }
    else if(checkRows(o) || checkCols(o) || checkDiags(o)) {
      winner = o;
      return true;
    }
    return false;
  }

  public boolean checkRows (Content c) {
    for(int i = 0; i < ROWS; i++) {
      if((cell[i][0].content == cell[i][1].content) && (cell[i][0].content == cell[i][2].content) && cell[i][0].content == c) {
        return true;
      }
    }
    return false;
  }

  public boolean checkCols(Content c) {
    for(int i = 0; i < COLS; i++) {
      if((cell[0][i].content == cell[1][i].content) && (cell[0][i].content == cell[2][i].content) && cell[0][i].content == c) {
        return true;
      }
    }
    return false;
  }

  public boolean checkDiags(Content c) {
    if((cell[0][0].content == cell[1][1].content) && (cell[0][0].content == cell[2][2].content) && cell[0][0].content == c) {
      return true;
    }
    else if((cell[2][0].content == cell[1][1].content) && (cell[2][0].content == cell[0][2].content) && cell[2][0].content == c) {
      return true;
    }
    return false;
  }
}
