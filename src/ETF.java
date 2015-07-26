import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 05/02/15.
 */
public class ETF {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer T = Integer.parseInt(br.readLine());
    while(T-- > 0){
      Long N = Long.parseLong(br.readLine());
      Long temp = N;
      Long answer = N;
      for(long i=2;i <= temp;i+=2){
        if(temp%i == 0){
          answer *= i-1;
          answer /= i;

          while(temp%i == 0){
            temp/=i;
          }
        }
        if(i == 2){
          i=1;
        }
      }
      System.out.println(answer);
    }
  }
}
