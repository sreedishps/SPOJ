import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 28/01/15.
 */
public class FAVDICE {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0){
      T--;
      Integer N = Integer.parseInt(br.readLine());
      System.out.println(String.format("%.2f",find(N)));
    }
  }

  private static double find(Integer n) {
    Integer temp = n;
    double answer = 0.0;
    for(int i=1;i<=n;i++){
      answer += (double)temp/(double)i;
    }
    return answer;
  }
}
