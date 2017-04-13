import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreps on 8/26/2016.
 */
public class MUL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            System.out.println(new BigInteger(temp[0]).multiply(new BigInteger(temp[1])));
        }
    }
}
