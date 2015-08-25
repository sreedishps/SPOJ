import java.util.Scanner;

public class PARTY {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int budget = scanner.nextInt();
      int N = scanner.nextInt();

      if (budget == 0 && N == 0) {
        break;
      }
      int dp[][] = new int[N + 1][budget + 1];
      int currentFee = 0, currentFun = 0;
      for (int i = 0; i <= N; i++) {
        if (i != 0) {
          currentFee = scanner.nextInt();
          currentFun = scanner.nextInt();
        }
        for (int j = 0; j <= budget; j++) {
          if (i == 0 || j == 0) {
            dp[i][j] = 0;
            continue;
          }
          if (j >= currentFee) {
            dp[i][j] = Math.max(dp[i - 1][j],
                currentFun + dp[i - 1][j - currentFee]);
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
      int entranceFees = 0;
      for (int j = budget; j >= 0; j--) {
        if (dp[N][j] == dp[N][budget]) {
          entranceFees = j;
        } else {
          break;
        }
      }


      System.out.println(entranceFees + " " + dp[N][budget]);

//      for (int i = 0; i <= N; i++) {
//        for (int j = 0; j <= budget; j++) {
//          System.out.print(dp[i][j] + " ");
//        }
//        System.out.println();
//      }
    }
  }
}
