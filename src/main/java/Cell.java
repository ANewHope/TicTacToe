public class Cell {
  Content content;
  int row, col;
  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    content = Content.EMPTY;
  }
}
