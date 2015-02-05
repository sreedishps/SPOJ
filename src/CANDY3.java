import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 04/02/15.
 */
public class CANDY3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    String s;

    while(T > 0){
      T--;
      s = br.readLine();
      s = br.readLine();
      Long sum = 0L;
      Long N = Long.parseLong(s);
      for(long i=0;i<N;i++){
        s = br.readLine();
        sum += Long.parseLong(s);
        if(sum > N){
          sum = sum % N;
        }
      }
      if(sum%N == 0){
        System.out.println("YES");
      }else{
        System.out.println("NO");
      }
    }
  }
}
