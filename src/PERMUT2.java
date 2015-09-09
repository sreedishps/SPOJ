import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sreedish.ps on 15/05/15.
 */
public class PERMUT2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer n;
    while ((n = Integer.parseInt(sc.nextLine())) != 0) {
      Integer permutation[] = new Integer[n+1];
      StringTokenizer tokenizer = new StringTokenizer(sc.nextLine());
      for (int i = 1; i <= n; i++)
        permutation[i] = Integer.parseInt(tokenizer.nextToken());
      boolean isAmbiguous = true;
      for (int i = 1; i <= n; i++) {
        if (permutation[permutation[i]] != i) {
          isAmbiguous = false;
          System.out.println("not ambiguous");
          break;
        }
      }
      if (isAmbiguous)
        System.out.println("ambiguous");
    }

  }
}
