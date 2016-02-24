import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 1/24/16.
 */
public class FRUITS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(in.readLine());
        while (T-- > 0){
            String temp[] = in.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);
            Integer K = Integer.parseInt(temp[2]);

            Integer diff = Math.abs(N - M);

            if(diff.compareTo(K) >= 0){
                diff -=K;
            }else {
                diff = 0;
            }

            System.out.println(diff);
        }
    }
}
