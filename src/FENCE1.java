import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 15/01/15.
 */
public class FENCE1 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true){
      Integer L = Integer.parseInt(br.readLine());
      if(L.equals(0)){
        break;
      }
      String answer = String.format("%.2f", (L * L ) /(2 * Math.PI));
      System.out.println(answer);
    }

  }
}
