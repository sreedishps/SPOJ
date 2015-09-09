import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TWOSQRS {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      Long num = Long.parseLong(br.readLine());
      Long i = 0l;
      Long j = (long) Math.sqrt(num);

      while (true) {
        Long sum = (i * i + j * j);
        if (sum.equals(num)) {
          System.out.println("Yes");
          break;
        } else if (sum > num){
            j--;
        } else{
            i++;
        }
        if(i > j){
          System.out.println("No");
          break;
        }
      }
    }
  }
}
