import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");

            Integer A = Integer.parseInt(temp[0]);
            Integer B = Integer.parseInt(temp[1]);


            boolean sieve[] = new boolean[ B - A + 1];

            for(int i = 2 ; i <= Math.ceil(Math.sqrt(B)) ; i++ ){
                for(int j = A - (A % i )  ; j <= B ; j+=i){
                    if(j < A){
                        continue;
                    }

                    if(i == j){
                        continue;
                    }
                    sieve[j-A] = true;
                }
            }

            for(int i = A ; i <= B ; i++){
                if(!sieve[i-A]){
                    if(i == 1){
                        continue;
                    }
                    System.out.println(i);
                }
            }
            System.out.println();

        }
    }
}
