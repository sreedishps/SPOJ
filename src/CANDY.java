import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 13/01/15.
 */
public class CANDY {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true){
      Integer N = Integer.parseInt(br.readLine());
      if(N.equals(-1)){
        break;
      }
      int arr[] = new int[N];
      long sum =0L;
      for(int i=0;i<N;i++){
        arr[i] = Integer.parseInt(br.readLine());
        sum += arr[i];
      }

      if(sum % N !=0){
        System.out.println("-1");
      }
      else{
        long div = sum/N;
        long moves = 0;
        for(int i=0;i<N;i++){
          if(arr[i] > div){
            moves += (arr[i]-div);
          }
        }
        System.out.println(moves);
      }
    }

  }
}
