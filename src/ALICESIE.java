import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALICESIE {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      Integer N = Integer.parseInt(br.readLine());
      solve(N);
    }
  }

  private static void solve(Integer n) {
    if (n % 2 == 0) {
      System.out.println(n / 2);
    } else {
      System.out.println(n / 2 + 1);
    }
  }
}
