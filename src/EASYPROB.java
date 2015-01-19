/**
 * Created by sreedish.ps on 15/01/15.
 */
public class EASYPROB {
  public static void main(String[] args) {
    get(137);
  }

  private static void get(int i) {
    int n = 32768;
    int k = i;
    while(true){
      if(i > n){
        i = i - n;
        System.out.print(n+"+");
      }
      if(i == n){
        break;
      }

      n = n/2;
    }

  }
}
