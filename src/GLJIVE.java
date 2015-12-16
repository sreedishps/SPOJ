import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GLJIVE {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer sum = 0, prevsum = 0;
    for (int i = 0; i < 10; i++) {
      Integer T = Integer.parseInt(br.readLine());

      if (sum < 100) {
        prevsum = sum;
        sum += T;
      }
    }

    if ((100 - prevsum) == (sum - 100)) {
      System.out.println(sum);
    } else if ((100 - prevsum) < (sum - 100)) {
      System.out.println(prevsum);
    } else {
      System.out.println(sum);
    }


  }
}
