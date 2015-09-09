import java.util.Arrays;
import java.util.Scanner;

public class PIGBANK {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer T = sc.nextInt();
    while (T-- > 0) {
      int E = sc.nextInt();
      int F = sc.nextInt();

      int weight = F - E;

      int coins = sc.nextInt();
      int priceWeight[][] = new int[coins][2];

      for (int i = 0; i < coins; i++) {
        priceWeight[i][0] = sc.nextInt();
        priceWeight[i][1] = sc.nextInt();
      }

      if (weight == 0) {
        print(0);
        continue;
      }

      int dp[] = new int[weight + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;

      for (int i = 1; i <= weight; i++) {
        for (int j = 0; j < coins; j++) {
          if (i == priceWeight[j][1]) {
            dp[i] = Math.min(dp[i], priceWeight[j][0]);
          } else if(i >= priceWeight[j][1]) {
            if (dp[i - priceWeight[j][1]] != Integer.MAX_VALUE) {
              dp[i] = Math.min(dp[i - priceWeight[j][1]] + priceWeight[j][0],
                  dp[i]);
            }
          }
        }
      }

    //  print(dp[50]) ;
      print(dp[weight]);


    }
  }

  private static void print(int i) {
    if (i != Integer.MAX_VALUE) {
      System.out.println(
          "The minimum amount of money in the piggy-bank is " + i + ".");
    } else {
      System.out.println("This is impossible.");
    }
  }

}
