import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EDIST {

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(f.readLine());
    while (t-- > 0) {
      editDistance(f.readLine(), f.readLine());
    }
  }

  private static void editDistance(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();

    int dp[][] = new int[len1 + 1][len2 + 1];
    dp[0][0] = 0;

    for (int i = 1; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= len2; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i - 1][j - 1]) + 1;
        }
      }
    }

    System.out.println(dp[len1][len2]);


  }
}
