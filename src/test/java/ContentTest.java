import static org.junit.Assert.*;
import org.junit.Test;

public class ContentTest {
  @Test
  public void emptyTest() {
    Content con = Content.EMPTY;
    assertEquals("", con.toString());
  }
  @Test
  public void exTest() {
    Content con = Content.EX;
    assertEquals("<img src=\"http:\\/\\/i62.tinypic.com\\/20tgthh.jpg\">", con.toString());
  }
  @Test
  public void zeroTest() {
    Content con = Content.ZERO;
    assertEquals("<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">", con.toString());
  }

  @Test
  public void valueOfTest() {
    assertEquals(Content.EMPTY, Content.valueOf("EMPTY"));
    assertEquals(Content.EX, Content.valueOf("EX"));
    assertEquals(Content.ZERO, Content.valueOf("ZERO"));
  }
  @Test
  public void valuesTest() {
    Content[] cons = new Content[3];
    cons[0] = Content.EMPTY;
    cons[1] = Content.EX;
    cons[2] = Content.ZERO;
    int it = 0;
    for(Content c : Content.values()) {
      assertEquals(cons[it], c);
      it++;
    }
  }
}
