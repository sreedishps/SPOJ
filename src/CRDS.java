import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 27/01/15.
 */
public class CRDS {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0){
      T--;
      Integer N = Integer.parseInt(br.readLine());
      System.out.println(find(N));
    }
  }

  private static BigInteger find(Integer n) {
    BigInteger tn = new BigInteger((2 +  (n - 1) * 3)+"" );
    BigInteger answer = tn.add(new BigInteger("2"));
    answer = answer.multiply(new BigInteger(""+n)).divide(new BigInteger("2"));
    answer = answer.mod(new BigInteger("1000007"));
    return answer;
  }
}
