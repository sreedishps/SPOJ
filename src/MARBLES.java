import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 14/01/15.
 */
public class MARBLES {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T >0) {
      T--;
      String s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer K = Integer.parseInt(s.split(" ")[1]);

      System.out.println(C2(N-1,K-1));
    }
  }

  private static long nCk(Integer n, Integer k) {
   long C[] = new long[k+1];

    Integer i, j;

    C[0] = 1L;

    for(i = 1; i <= n; i++)
    {
      for(j = Math.min(i, k); j > 0; j--)
        C[j] = C[j] + C[j-1];
    }

    return C[k];

  }
  private static BigInteger binomial(final long N, final long K) {
    BigInteger ret = BigInteger.ONE;
    for (long k = 0; k < K; k++) {
      ret = ret.multiply(BigInteger.valueOf(N-k))
        .divide(BigInteger.valueOf(k+1));
    }
    return ret;
  }

  private static Long C2 (Integer n, Integer r) {
    Long res = 1L,i;
    if(r > n/2)
      r = n-r;
    for(i = 0L; i < r; i++) {
      res *=  n;
      res /= i+1;
      n--;
    }
    return res;
  }


}
