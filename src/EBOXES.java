import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 10/11/15.
 */
public class EBOXES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer K = Integer.parseInt(temp[1]);
            Integer T1 = Integer.parseInt(temp[2]);
            Integer F = Integer.parseInt(temp[3]);

            System.out.println(N + ((F - N) * K)/(K-1));
        }
    }
}
