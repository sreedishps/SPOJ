import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 18/11/14.
 */
public class FCTRL2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T >0){
      T--;
      Long num = Long.parseLong(br.readLine());
      BigInteger fact = new BigInteger("1");
      while(num > 1){
        fact = fact.multiply(new BigInteger(num+""));
        num--;
      }
      System.out.println(fact);
    }
  }

}
