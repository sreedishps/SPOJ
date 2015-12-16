import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 11/14/15.
 */
public class MINCOUNT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long T = Long.parseLong(br.readLine());
        while (T-- >0){
            BigInteger N = new BigInteger(br.readLine());
            N = N.multiply(N.add(BigInteger.ONE));
            N = N.divide(new BigInteger("6"));
            System.out.println(N);
        }
    }
}
