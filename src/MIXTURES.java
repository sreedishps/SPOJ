import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MIXTURES {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n;
    String temp;
    while((temp = in.readLine()) != null){
      n = Integer.parseInt(temp);
      StringTokenizer st = new StringTokenizer(in.readLine());
      int[] mixture = new int[100];
      for(int i = 0; i < n; i++)
        mixture[i] = Integer.parseInt(st.nextToken());
      int[][] c = new int[n][n];
      int[][] s = new int[n][n];
      for(int i = 0; i < n; i++)
        c[i][i] = mixture[i];
      for(int a = 1; a < n; a++)
        for(int b = 0; b < n-a; b++){
          int i = b, j = b+a;
          s[i][j] = Integer.MAX_VALUE;
          int mink = 0;
          for(int k = i; k < j; k++)
            if((c[i][k]*c[k+1][j] + s[i][k] + s[k+1][j])< s[i][j]){
              s[i][j] = c[i][k]*c[k+1][j] + s[i][k] + s[k+1][j];
              mink = k;
            }c[i][j] = (c[i][mink] + c[mink+1][j])%100;
        }
      System.out.println(s[0][n-1]);
    }


//    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    int n;
//    String temp;
//    while((temp = in.readLine()) != null) {
//      n = Integer.parseInt(temp);
//      StringTokenizer st = new StringTokenizer(in.readLine());
//      int[] arr = new int[100];
//
//      for(int i = 0; i < n; i++)
//        arr[i] = Integer.parseInt(st.nextToken());
//
//      if (n == 1) {
//        System.out.println("0");
//        continue;
//      } else if (n == 2) {
//        System.out.println(arr[0] * arr[1]);
//        continue;
//      } else {
//        solve(arr, n);
//      }
//    }
  }

  private static void solve(int[] arr, int N) {
    long dp[][] = new long[N][N];

    for(int i=0;i<N;i++){
      dp[i][i] =0l;
    }

    for(int length = 2; length < N ;length++){
      for (int i = 1; i < (N - length + 1); i++) {

        int j = i+length-1 ;

        dp[i][j] = Long.MAX_VALUE;

        for (int k = i ; k < j; k++) {
          Long current = dp[i][k] + dp [k+1][j] + arr[i-1] * arr[k] * arr[j];
          if(current.compareTo(dp[i][j]) < 0){
            dp[i][j] = current;
          }
        }
      }
    }

    for (int i = 0; i < N ; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }


    System.out.println(dp[1][N-1]);

  }

}
