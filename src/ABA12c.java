import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreps on 11/3/2016.
 */
public class ABA12c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer K = Integer.parseInt(temp[1]);

            temp = br.readLine().split(" ");
            Integer price[] = new Integer[K + 1];

            for (int i = 1; i <= K; i++) {
                price[i] = Integer.parseInt(temp[i - 1]);
            }

            int dp[][] = new int[K + 1][K + 1];

            for(int i = 0; i <= K ; i++){
                for (int j = 0; j <=K ; j++) {
                    dp[i][j] = 500000;
                    if(j== 0){
                        dp[i][j] = 0;
                    }
                }
            }

            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K; j++) {
                    if(price[i] == -1 || j < i){
                        dp[i][j] = dp[i-1][j];
                        continue;
                    }
                    dp[i][j] = Math.min( dp[i-1][j] , dp[i][j-i] + price[i]);
                }
            }

            if(dp[K][K] >= 500000){
                System.out.println("-1");
                continue;
            }
            System.out.println(dp[K][K]);

        }

    }
}
