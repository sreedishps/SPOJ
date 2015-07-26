import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 14/04/15.
 */
public class EIGHTS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer t = sc.nextInt();
    String arr[] = {"192","442","692","942"};
    while(t > 0){
      t--;
      String temp = sc.next();
      BigInteger num = new BigInteger(temp).subtract(BigInteger.ONE);
      BigInteger answer = num.divide(new BigInteger("4"));
      answer = answer.multiply(new BigInteger("1000"));
      BigInteger offset = num.mod(new BigInteger("4"));
      answer = answer.add(new BigInteger(arr[offset.intValue()]));
      System.out.println(answer);
    }

  }
}
