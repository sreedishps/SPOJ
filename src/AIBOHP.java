import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AIBOHP {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String str = br.readLine();
      Integer ans = str.length() - lcs(str,
          new StringBuffer(str).reverse().toString());

      System.out.println(ans);

    }

  }

  private static int lcs(String str1, String str2) {
    int length = str1.length();
    int dp[][] = new int[length + 1][length + 1];

    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= length; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[length][length];
  }

  private static int getMaxEnd(String str) {
    int len = str.length();
    int endChar = str.charAt(len - 1);
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == endChar) {
        if (checkPalindrome(str, i, len - 1)) {
          return len - 1 - i + 1;
        }
      }
    }
    return 0;
  }

  private static int getMaxStart(String str) {
    int startChar = str.charAt(0);
    int len = str.length();
    for (int i = len - 1; i >= 0; i--) {
      if (str.charAt(i) == startChar) {
        if (checkPalindrome(str, 0, i)) {
          return i + 1;
        }
      }
    }
    return 0;
  }

  private static boolean checkPalindrome(String str, int start, int end) {
    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

}
