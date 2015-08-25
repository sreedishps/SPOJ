import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRT {
  static int value[];
  static int N;
  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    value = new int[N];
    cache = new int[N][N];
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        cache[i][j] = -1;
      }
    }
    for(int i =0;i< N;i++) {
      value[i] = Integer.parseInt(br.readLine() );
    }

    System.out.println(profit(0,N-1));

  }

  private static int profit(int beg, int end) {
    if(beg > end){
      return 0;
    }

    if(cache[beg][end] != -1){
      return   cache[beg][end];
    }

    int year = N - (end - beg)  ;
    cache[beg][end]  = Math.max(year * value[beg] + profit(beg+1,end),year * value[end] + profit(beg,end-1));
    return  cache[beg][end];
  }

}
