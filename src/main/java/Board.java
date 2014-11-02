public class Board {
  Cell[][] cell;
  public Board() {
    int rows = 3;
    int cols = 3;
    cell = new Cell[rows][cols];
    for(int r = 0; r < rows; r++) {
      for(int c = 0;  c < cols; c++) {
        cell[r][c] = new Cell(r,c);
      }
    }
  }
  public void init() {
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        cell[r][c].content = Content.EMPTY;
      }
    }
  }
    
}
