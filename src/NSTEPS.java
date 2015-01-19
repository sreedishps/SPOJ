import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 12/01/15.
 */
public class NSTEPS {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    Integer T = Integer.parseInt(s);

    while(T >0) {
      T--;
      s = br.readLine();
      Integer x = Integer.parseInt(s.split(" ")[0]);
      Integer y = Integer.parseInt(s.split(" ")[1]);

      if(x.equals(y) && (x%2 == 0)){
        System.out.println(2*x);
      }
      else if(x.equals(y) && (x%2 != 0)){
        System.out.println(2*x -1);
      }
      else if( x.equals(y+2) && (x%2 == 0)){
        System.out.println(x+y);
      }
      else if( x.equals(y+2) && (x%2 != 0)){
        System.out.println(x+y-1);
      }else{
        System.out.println("No Number");
      }
    }
  }
}
