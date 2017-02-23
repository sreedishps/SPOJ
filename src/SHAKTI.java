import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish on 23/2/17.
 */
public class SHAKTI {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Integer T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());

            if(N % 2 == 0){
                System.out.println("Thankyou Shaktiman");
            }else {
                System.out.println("Sorry Shaktiman");
            }
        }

    }
}
