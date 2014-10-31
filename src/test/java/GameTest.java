import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {
  final Game game = new Game();

  @Test
  public void checkGame() {
    assertEquals(3, game.ROWS);
    assertEquals(3, game.COLS);
    assertEquals(150, game.CELL_SIZE);
  }
}
