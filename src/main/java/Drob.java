import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Drob {
  private int numerator;
  private int denum;

  public Drob(int numerator, int denum) {
    this.numerator = numerator;
    this.denum = denum;
  }
}
