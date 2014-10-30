import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertFalse
import org.junit.Test;

public class BoardTest {
  final Board board = new Board();

  @Test
  public void checkTieEmptyBoard() {
    assertFalse(board.checkTie());
  }

  @Test
  public void checkWinEmptyBoard() {
    assertFalse(board.checkWin());
  }
