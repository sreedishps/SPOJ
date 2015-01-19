import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 17/01/15.
 */
public class NGM {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Long N = Long.parseLong(br.readLine());

    if(N %10 != 0){
      System.out.println("1");
      System.out.println(N%10);
    }else{
      System.out.println("2");
    }
  }
}
