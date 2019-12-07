import org.junit.jupiter.api.Test;

public class SecondTest {
  @Test
  public void test1() {
    Drob drob1 = new Drob(12, 6);
    Drob drob2 = new Drob(14, 8);
    System.out.println(drobSummary(drob1, drob2).getNumerator());
    System.out.println(drobSummary(drob1, drob2).getDenum());
  }

  public static Drob drobSummary(Drob drob1, Drob drob2) {
    return new Drob(
        drob1.getNumerator() * drob2.getDenum() + drob2.getNumerator() * drob1.getDenum(),
        drob1.getDenum() * drob2.getDenum());
  }
}
