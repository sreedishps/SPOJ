import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/22/15.
 */
public class SEAARASU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- >0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp[] = br.readLine().split(" ");
            Long inp[] = new Long[N];
            for(int i =0;i<N;i++){
                inp[i] = Long.parseLong(temp[i]);
            }

            System.out.println(gcdModified(inp,N));
        }
    }

    private static Long gcdModified(Long[] inp, Integer N) {
        Long gcd = inp[0];
        for(int i = 1;i<N;i++){
            gcd = gcd(gcd,inp[i]);
        }
        return gcd * N;
    }

    private static Long gcd(Long a, Long b) {
        while (!b.equals(0l)){
            Long temp = b;
            b = a %b;
            a = temp;
        }
        return a;
    }
}
