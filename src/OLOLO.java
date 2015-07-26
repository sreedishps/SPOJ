import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OLOLO {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     Integer i = Integer.parseInt(br.readLine());
    Long answer = 0L;
    while(i >0){
      i--;
      Long next = Long.parseLong(br.readLine());
      answer = answer ^ next ;
    }

    System.out.println(answer);
  }
}
