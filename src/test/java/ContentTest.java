import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContentTest {
  @Test
  public void emptyTest() {
    assertEquals("", Content.EMPTY.toString());
  }
  @Test
  public void exTest() {
    assertEquals("<img src=\"http:\\/\\/oi62.tinypic.com/2lxv8s1.jpg\">", Content.EX.toString());
  }
  @Test
  public void zeroTest() {
    assertEquals("<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">", Content.ZERO.toString());
  }
}
