import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 21/05/15.
 */
public class BYTESM2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(br.readLine());
    String temp;

    while (N > 0) {
      N--;
      temp = br.readLine();
      Integer h, w;
      h = Integer.parseInt(temp.split(" ")[0]);
      w = Integer.parseInt(temp.split(" ")[1]);

      int arr[][] = new int[h + 1][w + 2];


      for (int i = 1; i <= h; i++) {
        temp = br.readLine();
        for (int j = 1; j <= w; j++) {
          arr[i][j] = Integer.parseInt(temp.split(" ")[j - 1]) + max(arr[i - 1][j - 1], arr[i - 1][j], arr[i - 1][j + 1]);
        }
      }

      int max = 0;
      for (int j = 1; j <= w; j++) {
        if (max < arr[h][j]) {
          max = arr[h][j];
        }
      }

      System.out.println(max);
    }


  }

  private static int max(int i, int j, int k) {
    int max = 0;
    if (i > j) {
      max = i;
    } else {
      max = j;
    }

    if (max > k) {
      return max;
    } else {
      return k;
    }
  }
}
