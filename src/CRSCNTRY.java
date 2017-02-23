import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by sreedish on 14/3/16.
 */
public class CRSCNTRY {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().split(" ")[0]);
        while (T-- > 0) {
            String girl = br.readLine();
            String temp[] = girl.split(" ");
            int girlRoute = temp.length;
            int girlCheckpoints[] = new int[girlRoute];

            for (int i = 0; i < girlRoute; i++) {
                if(Integer.parseInt(temp[i]) == 0){
                    girlRoute = i;
                    break;
                }
                girlCheckpoints[i] = Integer.parseInt(temp[i]);
            }

            int max = -1;

             while (true) {
                String boy = br.readLine();
                String[] temp1 = boy.split(" ");
                if (Integer.parseInt(temp1[0]) == 0) {
                    break;
                }

                int boyRoute = temp1.length;
                int boyCheckPoints[] = new int[boyRoute];


                for (int i = 0; i < boyRoute; i++) {
                    if (Integer.parseInt(temp1[i]) == 0) {
                        boyRoute = i;
                        break;
                    }
                    boyCheckPoints[i] = Integer.parseInt(temp1[i]);

                }


                int dp[][] = new int[girlRoute+1][boyRoute+1];

                for (int i = 0; i <= girlRoute; i++) {
                    for (int j = 0; j <= boyRoute; j++) {
                        if(i == 0 || j == 0 ){
                            dp[i][j] = 0;
                        }else if(boyCheckPoints[j-1] == girlCheckpoints[i-1]){
                            dp[i][j] = dp[i-1][j-1] + 1;
                        }else {
                            dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                        }
                    }
                }

                 if(max < dp[girlRoute][boyRoute]){
                     max = dp[girlRoute][boyRoute];
                 }
            }

            System.out.println(max);
        }
    }
}
