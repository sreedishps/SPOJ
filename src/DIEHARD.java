import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/25/2016.
 */
public class DIEHARD {
    static int dp[][] = new int[2000][2000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            Integer H = Integer.parseInt(temp[0]);
            Integer A = Integer.parseInt(temp[1]);

            for(int i =0;i<2000;i++){
                for(int j=0;j<2000;j++){
                    dp[i][j] = -1;
                }
            }

            int minutes = getMax(H,A,0);
            System.out.println(minutes-1);
        }
    }

    private static int getMax(int H, int A, int seconds) {

        if((H <= 0) || (A <= 0)){
            return seconds;
        }

        if(dp[H][A] != -1){
            return dp[H][A];
        }

        if(seconds % 2 == 0){
            dp[H+3][A+2] = getMax(H+3,A+2,seconds + 1);
            return dp[H+3][A+2];
        }
        dp[H][A] = Math.max(getMax(H-5,A-10,seconds+1),getMax(H-20,A+5,seconds+1));
        return dp[H][A];
    }
}
