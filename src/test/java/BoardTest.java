import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest {
  @Test
  public void initTestEmptyBoard() {
    Board board = new Board();
    board.init();
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        assertEquals(Content.EMPTY, board.cell[r][c].content);
      }
    }
  }
  @Test
  public void checkTieTest() {
    Board board = new Board();
    board.init();
    assertEquals(false, board.checkTie());
    board.cell[0][0].content = Content.EX;
    board.cell[0][1].content = Content.ZERO;
    board.cell[0][2].content = Content.EX;
    board.cell[1][0].content = Content.ZERO;
    board.cell[1][1].content = Content.EX;
    board.cell[1][2].content = Content.EX;
    board.cell[2][0].content = Content.ZERO;
    board.cell[2][1].content = Content.EX;
    board.cell[2][2].content = Content.ZERO;
    assertEquals(true, board.checkTie());
  }
  @Test
  public void checkRowsTest() {
    Board board = new Board();
    board.init();
    assertEquals(true, board.checkRows(Content.EMPTY));
    assertEquals(false, board.checkRows(Content.ZERO));
    assertEquals(false, board.checkRows(Content.EX));
    board.cell[0][0].content = Content.EX;
    board.cell[0][1].content = Content.EX;
    board.cell[0][2].content = Content.EX;
    assertEquals(true, board.checkRows(Content.EX));
    board.cell[1][0].content = Content.ZERO;
    board.cell[1][1].content = Content.ZERO;
    board.cell[1][2].content = Content.ZERO;
    assertEquals(true, board.checkRows(Content.ZERO));
  }
  @Test
  public void checkColsTest() {
    Board board = new Board();
    board.init();
    assertEquals(true, board.checkCols(Content.EMPTY));
    assertEquals(false, board.checkCols(Content.ZERO));
    assertEquals(false, board.checkCols(Content.EX));
    board.cell[0][0].content = Content.EX;
    board.cell[1][0].content = Content.EX;
    board.cell[2][0].content = Content.EX;
    assertEquals(true, board.checkCols(Content.EX));
    board.cell[0][1].content = Content.ZERO;
    board.cell[1][1].content = Content.ZERO;
    board.cell[2][1].content = Content.ZERO;
    assertEquals(true, board.checkCols(Content.ZERO));
  }
  @Test
  public void checkDiagsTest() {
    Board board = new Board();
    board.init();
    assertEquals(true, board.checkDiags(Content.EMPTY));
    assertEquals(false, board.checkDiags(Content.ZERO));
    assertEquals(false, board.checkDiags(Content.EX));
    board.cell[0][0].content = Content.EX;
    board.cell[1][1].content = Content.EX;
    board.cell[2][2].content = Content.EX;
    assertEquals(true, board.checkDiags(Content.EX));
    board.cell[0][2].content = Content.ZERO;
    board.cell[1][1].content = Content.ZERO;
    board.cell[2][0].content = Content.ZERO;
    assertEquals(true, board.checkDiags(Content.ZERO));
  }
  @Test
  public void checkRowWinTest() {
    Board board = new Board();
    board.init();
    assertEquals(false, board.checkWin());
    board.cell[0][0].content = Content.EX;
    board.cell[0][1].content = Content.EX;
    board.cell[0][2].content = Content.EX;
    assertEquals(true, board.checkWin());
    assertEquals(Content.EX, board.winner);
  }
  @Test
  public void checkColWinTest() {
    Board board = new Board();
    board.init();
    assertEquals(false, board.checkWin());
    board.cell[0][0].content = Content.EX;
    board.cell[1][0].content = Content.EX;
    board.cell[2][0].content = Content.EX;
    assertEquals(true, board.checkWin());
    assertEquals(Content.EX, board.winner);
  }
  @Test
  public void checkDiagWinTest() {
    Board board = new Board();
    board.init();
    assertEquals(false, board.checkWin());
    board.cell[0][0].content = Content.ZERO;
    board.cell[1][1].content = Content.ZERO;
    board.cell[2][2].content = Content.ZERO;
    assertEquals(true, board.checkWin());
    assertEquals(Content.ZERO, board.winner);
  }
}
