import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 13/01/15.
 */
public class ACPC10A {
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while(true){
      s = br.readLine();
      int a = Integer.parseInt(s.split(" ")[0]);
      int b = Integer.parseInt(s.split(" ")[1]);
      int c = Integer.parseInt(s.split(" ")[2]);



      if(a == 0 && b == 0 && c == 0){
        break;
      }else if((b-a) == (c-b)){ //AP
        System.out.println("AP "+(c + (b-a)));
      }else if(c/b==b/a && b!=0 & a!=0){ //GP
        System.out.println("GP "+(c*(b/a)));
      }
    }

    br.close();

  }
}
