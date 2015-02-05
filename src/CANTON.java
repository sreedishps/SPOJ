import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 28/01/15.
 */
public class CANTON {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0){
      T--;
      Integer N = Integer.parseInt(br.readLine());
      System.out.println(find(N));
    }
  }

  private static String find(Integer n) {
    long num = 0;
    long i = 1;
    long offset = 0;
    for(i = 1; ; i++){
      num = num + i;
      if(num >= n){
        break;
      }
    }

    long numerator = 0;
    long denominator = 0;
    offset = num - n;
    if(i%2 == 0){
      numerator = i - offset;
      denominator = i+1 - numerator;
    }else{
      offset = i - offset - 1 ;
      numerator = i - offset;
      denominator = i+1 - numerator;
    }


    return "TERM "+n +" IS "+numerator + "/"+denominator;
  }
}
