import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CellTest {
  @Test
  public void constructorTest() {
    Cell cell = new Cell(2,3);
    assertEquals(Content.EMPTY, cell.content);
    assertEquals(2, cell.row);
    assertEquals(3, cell.col);
  }
}
