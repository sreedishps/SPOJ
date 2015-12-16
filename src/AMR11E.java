import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AMR11E {
    static boolean sieve[];
  public static void main(String[] args) throws IOException {

    sieve = new boolean[3000];

    for(int i=2;i<3000;){

      for(int j = 2 * i ;j<3000;j+=i){
        sieve[j] = true;
      }

      while (true){
        i++;
        if(i >= 3000){
          break;
        }
        if(!sieve[i]){
          break;
        }
      }
    }

    HashMap<Integer,Integer> lucky = new HashMap<Integer, Integer>();

    Integer i = 1;
    Integer now = 1;

     while (i <= 1000){
       if(test(now)){
         lucky.put(i,now);
         i++;
       }
      now++;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0){
      Integer N = Integer.parseInt(br.readLine());
      System.out.println(lucky.get(N));
    }

  }

  private static boolean test(Integer now) {
    int factors = 0;
    for(int i = 2 ; i<3000;i++){
         if(!sieve[i]){
             if(now % i == 0){
               factors++;
               if(factors == 3){
                 return  true;
               }
               while (now % i == 0){
                 now = now / i;
               }
             }
         }
    }
    return  false;
  }

}
