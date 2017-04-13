import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreps on 11/2/2016.
 */
public class Rock {
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());


        Integer counter = 0 ;
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp = br.readLine();

//            String temp = Integer.toBinaryString(counter);
//            counter++;
//            Integer N = temp.length();


            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = -1;
                }
            }



          //  int val1 = solve(temp.length(),temp);
            int val2 = solve(temp, 0,temp.length()-1);

            System.out.println(val2);
        }
    }

    private static int solve(String rock, int begin, int end) {
        if (dp[begin][end] != -1) {
            return dp[begin][end];
        }

        if (sweet(rock.substring(begin, end + 1))) {
            dp[begin][end] = end - begin + 1;
            return end - begin + 1;
        }

        int maximum = 0;
        for (int i = begin ; i < end; i++) {
            maximum = Math.max(maximum, solve(rock, begin, i) + solve(rock, i + 1, end));
        }

        dp[begin][end] = maximum;
        return maximum;
    }

    private static boolean sweet(String rock) {
        int swCounter = 0;
        int sourCounter = 0;

        for (int i = 0; i < rock.length(); i++) {
            if (rock.charAt(i) == '1') {
                swCounter++;
            } else {
                sourCounter++;
            }
        }
        return swCounter > sourCounter;
    }

    public static int solve(int n, String rock) {


        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++)

            sum[i] = sum[i - 1] + (rock.charAt(i - 1) == '1' ? 1 : 0);

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i - 1];

            for (int j = 1; j <= i; j++)

                if (sum[i] - sum[i - j] > (j >> 1))

                    if (dp[i - j] + j > dp[i])

                        dp[i] = dp[i - j] + j;

        }
        return dp[n];

    }


}

