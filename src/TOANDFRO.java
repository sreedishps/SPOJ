import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 27/12/14.
 */
public class TOANDFRO {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(br.readLine());
    while(N != 0){
      String s = br.readLine();


      for(int i=0;i<N;i++){
        boolean flag = true;
        for(int j=0;j < s.length() ; j+=N){
          if(flag){

            if((i+j) < s.length()){
              System.out.print(s.charAt(i + j));
            }
          }else{
            if((j + N -i) >=0 ){
              System.out.print(s.charAt(j + N - i - 1));
            }

          }
          flag = !flag;
        }
      }
      System.out.println();
      N = Integer.parseInt(br.readLine());
    }
  }
}
