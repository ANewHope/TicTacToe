import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CellTest {
  @Test
  public void constructorTest() {
    Cell cell = new Cell();
    assertEquals(Content.EMPTY, cell.content);
  }
}
