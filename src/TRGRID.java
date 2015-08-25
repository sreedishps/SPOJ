import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRGRID {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp[] = br.readLine().split(" ");
      Integer N = Integer.parseInt(temp[0]);
      Integer M = Integer.parseInt(temp[1]);
      solve(N, M);
    }
  }

  private static void solve(Integer N, Integer M) {
    if (N == 1) {
      System.out.println("R");
      return;
    } else if (M == 1) {
      System.out.println("D");
      return;
    } else if (N == 2) {
      System.out.println("L");
      return;
    } else if (M == 2) {
      System.out.println("U");
      return;
    } else if (N > 2 && M > 2) {
      Integer diff;
      diff = Math.min(N, M);
      if (diff % 2 == 0) {
        diff = diff - 2;
      } else {
        diff = diff - 1;
      }

      N -= diff;
      M -= diff;
      solve(N, M);
    }
  }
}

