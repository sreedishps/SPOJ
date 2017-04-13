import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 11/4/2016.
 */
public class CHSQR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            Integer seed = (N + 1 ) / 2;

            for(int i= 0 ; i < N ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j< N ; j++){
                    sb.append((seed+j) % N  + 1 +" ");
                }
                System.out.print(sb);
                seed++;
                if(i != N-1)
                System.out.println();
            }
        }
    }

}
