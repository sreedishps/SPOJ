import java.util.Scanner;

public class LASTDIG {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    while (N-- > 0) {
      int m;
      int q[][] = {{}, {}, {6, 2, 4, 8}, {1, 3, 9, 7}, {6, 4, 6, 4}, {}, {}, {1, 7, 9, 3}, {6, 8, 4, 2}, {1, 9, 1, 9}};
      Integer a=in.nextInt();
      Long b=in.nextLong();
      a%=10;
      if (b == 0) {
        System.out.println("1");
        continue;
      }
      if (a == 0 || a == 1 || a == 6 || a == 5) {
        System.out.println(a);
        continue;
      }
      m = (int) (b % 4);
      System.out.println(q[a][m] + "");
    }
  }
}
