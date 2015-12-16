import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class EC_CONB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      Integer N = Integer.parseInt(br.readLine());
      if (N % 2 != 0) {
        System.out.println(N);
      } else {
        System.out.println(Integer.parseInt(new StringBuilder(Integer.toBinaryString(N)).reverse().toString(),2));
      }
    }
  }

}
