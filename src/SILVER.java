import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SILVER {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      Integer T = Integer.parseInt(br.readLine());
      if(T == 0){
        break;
      }
      System.out.println((int)(Math.log(T)/Math.log(2)));
    }
  }

}
