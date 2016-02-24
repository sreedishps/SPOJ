import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by sreedish.ps on 2/3/16.
 */
public class PON {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            Long N = Long.parseLong(br.readLine());
            if(fermatTest(N,2)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }

   static  boolean fermatTest(Long number, int iterations){
        if( number == 1){
            return false;
        }
       Random random = new Random();

        for(int i=0;i<iterations;i++) {
            Long rand = (long) (random.nextLong()  % (number - 1)) + 1;
            if (moduloExpon(rand, number - 1, number) != 1) {
                return false;
            }
        }
        return true;
    }

   static  Long  moduloExpon(Long a, Long b, Long c) {
        Long x = 1l, y = a;
        while (b > 0) {
            if (b % 2 == 0) {
                x = x * y;
                x %= c;
            }
            y = y * y;
            y %= c;
            b = b / 2;
        }
        return x % c;
    }
}
