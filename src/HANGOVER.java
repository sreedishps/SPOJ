import java.util.Scanner;

/**
 * Created by sreedish.ps on 02/05/15.
 */
public class HANGOVER {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextDouble()) {
      Double T = scanner.nextDouble();
      if(T.equals(0.00)){
        break;
      }
    solve(T);
    }
    scanner.close();
  }

  public static void solve(Double t) {
    Double i =2.0;
    Double result = 0.0;
    while(true){
      result += (1/i);
      if(result.compareTo(t) > 0){
        i--;
        System.out.println(i.intValue()+" card(s)");
        return;
      }
      i++;
    }
  }
}
