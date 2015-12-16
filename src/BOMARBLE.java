import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOMARBLE {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true){
      int n = Integer.parseInt(in.readLine());
      if(n == 0){
        break;
      }
      System.out.println(5*n + (3 * n * (n-1) /2) - (n-1));
    }
  }

}
