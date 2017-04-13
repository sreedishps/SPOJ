import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreps on 11/4/2016.
 */
public class ALEXTASK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            Long input[] = new Long[N];

            String temp[] = br.readLine().split(" ");
            for(int i = 0; i<N ; i++){
                input[i] = Long.parseLong(temp[i]);
            }

            Arrays.sort(input);

            Long minCollision = Long.MAX_VALUE;

            for(int i=0;i<N ;i++){
                for(int j = i+1 ; j< N ;j++){
                    Long LCM = lcm(input[i],input[j]);
                    if(minCollision.compareTo(LCM) > 0){
                        minCollision = LCM;
                    }
                    if(j > minCollision){
                        break;
                    }
                }

                if(i > minCollision){
                    break;
                }
            }

            System.out.println(minCollision);
        }
    }

    private static Long lcm(Long aLong, Long aLong1) {
        return aLong * aLong1 / gcd(aLong,aLong1);
    }

    private static long gcd(Long a, Long b) {
        if (b == 0)
        return a;
        else
        return gcd(b, a%b);
    }
}
