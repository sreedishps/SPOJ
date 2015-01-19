import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 16/01/15.
 */
public class JULKA {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i=0;i<10;i++){
      BigInteger total = new BigInteger(br.readLine());
      BigInteger more = new BigInteger(br.readLine());

      BigInteger Natalia = total.subtract(more).divide(new BigInteger("2"));
      BigInteger claudia = Natalia.add(more);

      System.out.println(claudia);
      System.out.println(Natalia);
    }
  }
}
