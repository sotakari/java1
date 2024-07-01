import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
  @Test public void setName() {
    Bank b = new Bank();
    b.setName("ミヤビ");
  }

  @Test public void getNameWithNull() {
    try {
      Bank b = new Bank();
      b.setName(null);
    } catch (NullPointerException e) {
      return;
    }
    fail();
  }
  
  @Test
  public void throwsExceptionWithTwoName() {
    Bank b = new Bank();
    assertThrows(IllegalArgumentException.class, () -> { b.setName("ミヤ");});
  }
}