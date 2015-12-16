import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMR12D {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp = br.readLine();
      if (temp.equals(new StringBuffer(temp).reverse().toString())) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
