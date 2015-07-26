import java.util.HashSet;
import java.util.Scanner;

public class HYPNOS {
  static int arr[] = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
  static int counter =0;
  static HashSet hs = new HashSet();

  public static void main(String[] args) {
    long input;
    Scanner in = new Scanner(System.in);
    input = in.nextLong();
    solve(input);
  }

  private static void solve(long input) {
    long sum =0;
    while(input > 0){
     sum += arr[(int)(input%10)];
     input /= 10;
    }
    counter++;
    if(sum == 1){
      System.out.println(counter);
      return;
    }
    if(hs.contains(sum)){
      System.out.println("-1");
      return;
    }
    hs.add(sum);
    solve(sum);
  }
}
