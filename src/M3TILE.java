import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/4/15.
 */
public class M3TILE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long dp[] = new Long[50];
        dp[0]=1l;
        dp[1]=0l;
        dp[2]=3l;
        dp[3]=0l;

        for(int i= 4 ;i<=30;i++){
            dp[i]  = 4 * dp[i-2] - dp[i-4];
        }

        while (true){
            Integer N = Integer.parseInt(br.readLine());
            if(N.equals(-1)){
                break;
            }
            System.out.println(dp[N]);
        }

    }
}
