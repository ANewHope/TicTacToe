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
}
