import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 6/1/2016.
 */
public class GNYR09F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        //length, sum , 2
        long dp[][][] = new long[101][101][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (j > 0)
                    dp[i][j][1] = dp[i - 1][j - 1][1];
                dp[i][j][1] += dp[i - 1][j][0];
            }
        }

        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer cas = Integer.parseInt(temp[0]);
            Integer n = Integer.parseInt(temp[1]);
            Integer k = Integer.parseInt(temp[2]);

            System.out.println(cas+" "+dp[n][k][0] + dp[n][k][1]);

        }
    }
}
