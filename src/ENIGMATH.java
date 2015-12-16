import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ENIGMATH {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp[] = br.readLine().split(" ");
      Long A = Long.parseLong(temp[0]);
      Long B = Long.parseLong(temp[1]);
      Long gcd = gcd(A, B);

      System.out.println(B/gcd+" "+A/gcd);

    }
  }

  static Long gcd(Long a, Long b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }
}
