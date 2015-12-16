import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sreedish.ps on 11/17/15.
 */
public class PERMUT1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer k = Integer.parseInt(st.nextToken());

            Integer dp[][]= new Integer[100][14];

            for(int i=0;i<=k;i++)
                dp[i][0]=0;
            for(int i=0;i<=n;i++)
                dp[0][i]=1;
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    int m = i;
                    dp[i][j]=0;
                    int l=0;
                    while(m>=0&&l<j){
//                        if(i == 2 && j == 4){
//                            for(int i1=0;i1<=k;i1++) {
//                                for (int j1 = 0; j1 <= n; j1++) {
//                                    System.out.print(dp[i1][j1]+" ");
//                                }
//                                System.out.println();
//                            }
//                            System.out.println();
//                        }
                        dp[i][j]+=dp[m][j-1];
                        l++;
                        m--;
                    }
                }
            }
//
//            for(int i=0;i<=k;i++) {
//                for (int j = 0; j <= n; j++) {
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }

            System.out.println(dp[k][n]);
        }
    }
}
