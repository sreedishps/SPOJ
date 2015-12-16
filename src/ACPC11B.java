import java.util.Arrays;
import java.util.Scanner;

public class ACPC11B {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Integer T = in.nextInt();
    while (T-- > 0) {
      Integer N = in.nextInt();
      Integer first[] = new Integer[N];
      for (int i = 0; i < N; i++) {
        first[i] = in.nextInt();
      }

      Integer M = in.nextInt();
      Integer second[] = new Integer[M];
      for (int i = 0; i < M; i++) {
        second[i] = in.nextInt();
      }

      Arrays.sort(first);
      Arrays.sort(second);
      int i = 0, j = 0;
      Integer min = Integer.MAX_VALUE;
      int temp = 0;
      while (i < N && j < M) {
        if (first[i].equals(second[j])) {
          min = 0;
          i = N;
          j = M;
          break;
        } else if (first[i].compareTo(second[j]) > 0) {
          temp = first[i] - second[j];
          if (Math.abs(temp) < min) {
            min = temp;
          }
          j++;
        } else {
          temp = second[j] - first[i];
          if (Math.abs(temp) < min) {
            min = temp;
          }
          i++;
        }
      }

      while (i < N) {
        temp = second[M - 1] - first[i];
        if (Math.abs(temp) < min) {
          min = temp;
        }
        i++;
      }

      while (j < M) {
        temp = first[N - 1] - second[j];
        if (Math.abs(temp) < min) {
          min = temp;
        }
        j++;
      }

      System.out.println(min);
    }
  }

}
