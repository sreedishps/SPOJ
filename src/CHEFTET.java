import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/3/2016.
 */
public class CHEFTET {
    static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp[] = br.readLine().split(" ");
            Integer b[] = new Integer[N];
            dp = new boolean[N+2][N+2];

            for (int i = 0; i < N; i++) {
                b[i] = Integer.parseInt(temp[i]);
            }
            temp = br.readLine().split(" ");
            Integer a[] = new Integer[N];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            if (N == 1) {
                System.out.println(a[0] + b[0]);
                continue;
            }
            int check1 = a[0] + Math.max(b[0], b[1]);
            int check2 = a[0] + Math.min(b[0], b[1]);
            int check3 = a[0];
            int check4 = a[0] + b[0] + b[1];

            if (maxCheck(a, b, check4, N, 0, N - 1)) {
                reset(dp,N+2);
                System.out.println(check4);
            } else if (maxCheck(a, b, check1, N, 0, N - 1)) {
                reset(dp,N+2);
                System.out.println(check1);
            } else if (maxCheck(a, b, check2, N, 0, N - 1)) {
                reset(dp,N+2);
                System.out.println(check2);
            } else if (maxCheck(a, b, check3, N, 0, N - 1)) {
                reset(dp,N+2);
                System.out.println(check3);
            } else {
                System.out.println("-1");
            }
        }
    }

    private static void reset(boolean[][] dp, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = false;
            }
        }
    }

    private static boolean maxCheck(Integer[] a, Integer[] b, int check, Integer N, int left, int right) {
        if(dp[left][right]){
            return true;
        }
        if (left > right) {
            return true;
        }
        boolean zeroDrop = false, oneDropLeft = false, oneDropAbove = false, oneDropRight = false,
                twoDrop12 = false, twoDrop13 = false, twoDrop23 = false, threedrop = false;
        if (a[left] == check) {
            zeroDrop = maxCheck(a, b, check, N, left + 1, right);
            if (zeroDrop) {
                dp[left][right] = true;
                return true;
            }
        }

        if (left != 0) {
            if (a[left] + b[left - 1] == check) {
                int temp = b[left - 1];
                b[left - 1] = 0;
                oneDropLeft = maxCheck(a, b, check, N, left + 1, right);
                b[left - 1] = temp;
                if (oneDropLeft) {
                    dp[left][right] = true;
                    return true;
                }
            }

            if (a[left] + b[left - 1] + b[left] == check) {
                int temp = b[left - 1];
                int temp2 = b[left];
                b[left - 1] = 0;
                b[left] = 0;
                twoDrop12 = maxCheck(a, b, check, N, left + 1, right);
                b[left - 1] = temp;
                b[left] = temp2;
                if (twoDrop12) {
                    dp[left][right] = true;
                    return true;
                }
            }
        }

        if (a[left] + b[left] == check) {
            int temp = b[left];
            b[left] = 0;
            oneDropAbove = maxCheck(a, b, check, N, left + 1, right);
            b[left] = temp;

            if (oneDropAbove) {
                dp[left][right] = true;
                return true;
            }
        }

        if (left != N - 1) {

            if (a[left] + b[left + 1] + b[left] == check) {
                int temp = b[left + 1];
                int temp2 = b[left];
                b[left + 1] = 0;
                b[left] = 0;
                twoDrop23 = maxCheck(a, b, check, N, left + 1, right);
                b[left + 1] = temp;
                b[left] = temp2;
                if(twoDrop23){
                    dp[left][right] = true;
                    return true;
                }
            }

            if (a[left] + b[left + 1] == check) {
                int temp = b[left + 1];
                b[left + 1] = 0;
                oneDropRight = maxCheck(a, b, check, N, left + 1, right);
                b[left + 1] = temp;
                if(oneDropRight){
                    dp[left][right] = true;
                    return true;
                }
            }

        }

        if (left != 0 && left != N - 1) {
            if (a[left] + b[left + 1] + b[left - 1] == check) {
                int temp = b[left + 1];
                int temp2 = b[left - 1];
                b[left + 1] = 0;
                b[left - 1] = 0;
                twoDrop13 = maxCheck(a, b, check, N, left + 1, right);
                b[left + 1] = temp;
                b[left - 1] = temp2;
                if(twoDrop13){
                    dp[left][right] = true;
                    return true;
                }
            }

            if (a[left] + b[left + 1] + b[left] + b[left - 1] == check) {
                int temp = b[left + 1];
                int temp2 = b[left - 1];
                int temp3 = b[left];
                b[left + 1] = 0;
                b[left - 1] = 0;
                b[left] = 0;
                threedrop = maxCheck(a, b, check, N, left + 1, right);
                b[left + 1] = temp;
                b[left - 1] = temp2;
                b[left] = temp3;
                if(threedrop){
                    dp[left][right] = true;
                    return true;
                }
            }
        }

        return zeroDrop || oneDropAbove || oneDropLeft || oneDropRight || twoDrop12 || twoDrop13 || twoDrop23 || threedrop;
    }


}
