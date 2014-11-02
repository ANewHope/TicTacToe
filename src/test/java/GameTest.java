import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {
  @Test
  public void constructorTest() {
    Game game = new Game();
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        assertEquals(Content.EMPTY, game.board.cell[r][c].content);
      }
    }
    assertEquals(State.ON, game.currState);
    assertEquals(Content.EX, game.currPlayer);
  }
  @Test
  public void playerMoveTest() {
    Game game = new Game();
    assertEquals(false, game.playerMove(3,3));
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        game.playerMove(r,c);
      }
    }
    assertEquals(Content.EX, game.board.cell[0][0].content);
    assertEquals(false, game.playerMove(0,0));
    assertEquals(false, game.playerMove(1,1));
  }
  @Test
  public void getPlayerTest() {
    Game game = new Game();
    assertEquals(Content.EX.toString(), game.getPlayer());
  }
  @Test
  public void nextPlayerTest() {
    Game game = new Game();
    assertEquals(Content.EX.toString(), game.getPlayer());
    game.nextPlayer();
    assertEquals(Content.ZERO.toString(), game.getPlayer());
    game.nextPlayer();
    assertEquals(Content.EX.toString(), game.getPlayer());
  }
  @Test
  public void mainTest() {
    Game game = new Game();
    assertEquals(false, game.board.checkTie());
  }
  @Test
  public void initTest() {
    Game game = new Game();
    for(int r = 0; r < 3; r++) {
      assertEquals(true, game.playerMove(r,0));
    }
    //assertEquals(State.WIN, game.currState);
    //assertEquals(Content.EX, game.board.winner);
    game.init();
  }
}
