import java.io.*;
import java.util.Arrays;

public class AGGRCOW {
  private static Reader1 in;
  private static PrintWriter out;
  public static void main(String[] args) throws IOException {
     in = new Reader1();
    out = new PrintWriter(System.out, true);
    int T = in.nextInt();
    int stalls[] = null;
    while (T-- > 0) {
      int N = in.nextInt() ;
      int cows = in.nextInt();
      stalls = new int[N];
      for (int i = 0; i < N; i++) {
        stalls[i] = in.nextInt();
      }
//      if(cows == 2){
//        System.out.println(stalls[stalls.length - 1] - stalls[0]);
//        continue;
//      }
      out.println(getMostWork(stalls, cows));
    }
  }

  public static long getMostWork(int stalls[], int cows) {
    Arrays.sort(stalls);
    int n = stalls.length;
    int lo = 0, hi = stalls[n - 1] - stalls[0], mid;
    while (lo < hi) {
      mid = (lo + hi) >> 1;
      if (lo == mid) break;
      if (find(stalls, cows, mid)) lo = mid;
      else hi = mid - 1;
    }
    if (find(stalls, cows, hi)) lo = hi;
    return lo;

  }

  private static boolean find(int[] stalls, long cows, long mid) {
    long toBeassigned = cows;
    toBeassigned--;
    long currentDistance = 0l;
    //first cow is assigned to first stall
    for (int i = 1; i < stalls.length; i++) {
      long distance = stalls[i] - stalls[i - 1];
      if (distance + currentDistance < mid) {
        currentDistance += distance;
      } else {
        toBeassigned--;
        if (toBeassigned == 0) {
          return true;
        }
        currentDistance = 0;
      }
    }
    return false;
  }


  private static class Reader1 {
    public int nextInt() {
      return 0;
    }
  }
}
