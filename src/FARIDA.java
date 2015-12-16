import java.io.IOException;
import java.util.Scanner;

public class FARIDA {

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    Integer t = in.nextInt();
    int cse = 0;
    while (t-- > 0) {
      cse++;
      Integer N = in.nextInt();
      if (N.equals(0)) {
        System.out.println("Case " + cse + ": " + "0");
        continue;
      } else if (N.equals(1)) {
        System.out.println("Case " + cse + ": " + in.nextInt());
        continue;
      } else if (N.equals(2)) {
        System.out.println(
            "Case " + cse + ": " + Math.max(in.nextInt(), in.nextInt()));
        continue;
      }


      Long dp[] = new Long[3];
      dp[0] = 0l;
      dp[1] = 0l;
      dp[2] = 0l;

      Long current;
      for (int i = 1; i <= N; i++) {
        current = in.nextLong();
        dp[0] = dp[1];
        dp[1] = dp[2];
        dp[2] = Math.max(dp[0] + current, dp[1]);
      }

      System.out.println("Case " + cse + ": " + dp[2]);
      continue;

    }

  }

}