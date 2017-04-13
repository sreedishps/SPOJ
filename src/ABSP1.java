import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sreps on 8/26/2016.
 */
public class ABSP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            Integer N = Integer.parseInt(br.readLine());
            Integer input[] = new Integer[N];

            if(N <2){
                System.out.println("0");
                continue;
            }

            String temp[] = br.readLine().split(" ");
            for(int i =0 ; i< N ;i++){
                input[i] = Integer.parseInt(temp[i]);
            }

            Integer diff[] = new Integer[N-1];
            for(int i =1 ; i< N ;i++){
                diff[i-1] = input[i] - input[i-1];
            }

            Long answer = 0l;


            for(int i = 1 ; i< N ;i++){
                answer += (diff[i-1] * (N - i ) * i);
            }

            System.out.println(answer);
        }
    }
}
