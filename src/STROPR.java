import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 2/5/16.
 */
public class STROPR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Long N = Long.parseLong(temp[0]);
            Long X = Long.parseLong(temp[1]);
            Long M = Long.parseLong(temp[2]);

            Long inp[] = new Long[N.intValue()];
            temp = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                inp[i] = Long.parseLong(temp[i]);
            }

            for (int j = 0; j < M; j++) {
                for (int i = 1; i < N; i++) {
                    inp[i] += inp[i - 1];
                }
            }
            System.out.println(inp[X.intValue() - 1]);
        }
    }
}
