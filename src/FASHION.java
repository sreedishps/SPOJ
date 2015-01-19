import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreedish.ps on 16/01/15.
 */
public class FASHION {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T >0) {
      T--;
      Integer N = Integer.parseInt(br.readLine());
      String men[] = br.readLine().split(" ");
      String women[] = br.readLine().split(" ");

      Integer m[] = new Integer[N];
      Integer w[] = new Integer[N];



      for(int i =0;i<N;i++){
        m[i] = Integer.parseInt(men[i]);
        w[i] = Integer.parseInt(women[i]);
      }

      Arrays.sort(m);
      Arrays.sort(w);

      Long hot = 0L;

      for(int i =0;i<N;i++){
       hot += (m[i] * w[i]);
      }

      System.out.println(hot);
    }

  }
}
