import static org.junit.Assert.*;
import org.junit.Test;

public class StateTest {
  @Test
  public void valueOfTest() {
    assertEquals(State.ON, State.valueOf("ON"));
    assertEquals(State.TIE, State.valueOf("TIE"));
    assertEquals(State.WIN, State.valueOf("WIN"));
  }

  @Test
  public void valuesTest() {
    State[] states = new State[3];
    states[0] = State.ON;
    states[1] = State.TIE;
    states[2] = State.WIN;
    int it = 0;
    for(State s : State.values()) {
      assertEquals(states[it], s);
      it++;
    }
  }
}
