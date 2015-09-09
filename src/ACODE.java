import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ACODE {
  static HashMap<String, Long> dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    dp = new HashMap<String, Long>();
    while (true) {
      String str = br.readLine();
      if (str.equals("0")) {
        break;
      }
      if (str.contains("00")) {
        System.out.println("0");
        continue;
      }
      Long b = countOptimised(str);
      System.out.println(b);

    }
  }

  private static Long countOptimised(String str) {
    if (str.equals("0")) {
      return 0l;
    }
    if (str.contains("00")) {
      return 0l;
    }

    int len = str.length();
    Long dp[] = new Long[len + 1];
    dp[0] = 1l;
    dp[1] = 1l;

    for (int i = 2; i <= len; i++) {
      if (str.charAt(i - 1) == '0') {
        if (str.charAt(i - 2) >= '3') {
          return 0l;
        }
      }
      dp[i] = dp[i - 1];

      Integer num = Integer.parseInt(
          "" + str.charAt(i - 2) + str.charAt(i - 1));

      if (num <= 26 && str.charAt(i - 2) != '0' && str.charAt(i - 1) != '0') {
        if (i <= len - 1) {
          if (str.charAt(i) == '0') {
            continue;
          }
        }
        dp[i] += dp[i - 2];
      }
    }
    return dp[len];
  }

  private static Long count(String str) {
    if (str.length() == 1 && !str.equals("0")) {
      // dp.put(str, 1l);
      return 1l;
    }

    if (dp.containsKey(str)) {
      return dp.get(str);
    }


    if (str.equals("0")) {
      dp.put(str, 0l);
      return 0l;
    }

    if (str.length() == 2) {
      if (str.charAt(1) == '0' && (str.charAt(0) == 1) || (str.charAt(
          0) == 2)) {
        dp.put(str, 1l);
        return 1l;
      }
      if ((str.charAt(0) == '1') || (str.charAt(0) == '2' && str.charAt(
          1) <= '6')) {
        dp.put(str, 2l);
        return 2l;
      }
    }


    Long count = 0l;
    if (str.charAt(0) != '0' && str.length() > 1) {      // fix one letter word
      count += count(str.substring(1));
    }

    if (str.length() > 2) {
      if ((str.charAt(0) == '1') || (str.charAt(0) == '2' && str.charAt(
          1) <= '6')) {
        count += count(str.substring(2));
      }
    }
    dp.put(str, count);
    return count;
  }
}
