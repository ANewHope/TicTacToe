import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CellTest {
  final Cell cell = new Cell(1,1);

  @Test
  public void checkConstructor() {
    assertEquals(1, cell.row);
    assertEquals(1, cell.col);
    assertEquals(CellContent.EMPTY, cell.content);
  }
}
