import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BITMAP {
  static int arr[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp = br.readLine();
      Integer N = Integer.parseInt(temp.split(" ")[0]);
      Integer M = Integer.parseInt(temp.split(" ")[1]);

      arr = new int[N][M];

      for (int i = 0; i < N; i++) {
        temp = br.readLine();
        for (int j = 0; j < M; j++) {
          if ((temp.charAt(j)) == '1')
            arr[i][j] = 0;
          else arr[i][j] = Integer.MAX_VALUE;
        }
      }
      solve(arr, N, M);
      print(N, M);
      if(T == 0){
        break;
      }
      br.readLine();
    }
  }

  private static void solve(int[][] arr, Integer n, Integer m) {
    for (int distance = 0; distance < 400; distance++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] == distance) {
            if (i != 0) {
              if (arr[i - 1][j] > distance + 1) {
                arr[i - 1][j] = distance + 1;
              }
            }
            if (i != n - 1) {
              if (arr[i + 1][j] > distance + 1) {
                arr[i + 1][j] = distance + 1;
              }
            }
            if (j != 0) {
              if (arr[i][j - 1] > distance + 1) {
                arr[i][j - 1] = distance + 1;
              }
            }
            if (j != m - 1) {
              if (arr[i][j + 1] > distance + 1) {
                arr[i][j + 1] = distance + 1;
              }
            }
          }
        }
      }
    }
  }


  private static void print(int N, int M) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(arr[i][j]);
        if(j != M-1){
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
