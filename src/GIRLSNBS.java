import java.util.Scanner;

/**
 * Created by sreedish.ps on 21/05/15.
 */
public class GIRLSNBS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m,n;
    while (true){
      m = sc.nextInt();
      n = sc.nextInt();
      if(m == -1 && n == -1){
        break;
      }
      System.out.println(calculate(m,n));
    }
  }

  private static int calculate(int m, int n) {
    double big = (double) m>n?m:n;
    double small = (double) m>n?n:m;
    small++;
    big = big/small;
    return (int)Math.ceil(big);
  }
}
