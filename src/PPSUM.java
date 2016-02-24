import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 2/21/16.
 */
public class PPSUM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String a[];
            a = br.readLine().split(" ");

            Integer D = Integer.parseInt(a[0]);
            Integer N = Integer.parseInt(a[1]);

            for( int i = 0; i < D ; i++){
                N = sum(N);
            }

            System.out.println(N);
        }
    }

    private static Integer sum(Integer n) {
        return (n * (n+1))/2;
    }
}
