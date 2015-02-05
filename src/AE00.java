import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 05/02/15.
 */
public class AE00 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    int count =0;
    for(int i =1;i <= T;i++){
      for(int j = 1;j <= Math.sqrt(i);j++){
        if(i % j ==0){
          //System.out.println(i+" "+j);
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
