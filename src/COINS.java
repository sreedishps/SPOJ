import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 14/04/15.
 */
public class COINS {
  static int dp[];
  public static void main(String[] args) throws IOException{
    dp  = new int[50000];
    dp[0] = 0;
    for(int i=1;i<50000;i++){
      dp[i] = Math.max(i,(dp[(int)Math.floor(i/4)] + dp[(int)Math.floor(i/3)]+ dp[(int)Math.floor(i/2)]) );
    }


    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLong()) {
      long T = scanner.nextLong();
      System.out.println(solve(T));
    }
    scanner.close();
  }

  private static long solve(Long t) {
    if(t < 50000){
      return dp[t.intValue()];
    }else {
      return Math.max(t, solve(t / 4) + solve(t/3) + solve(t/2));
    }
  }

  private static long solveBrute(long t ){
    if(t < 12){
      return t;
    }else {
      return Math.max(t, solveBrute(t / 4) + solveBrute(t/3) + solveBrute(t/2));
    }
  }

}
