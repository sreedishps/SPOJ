import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 20/10/14.
 */
public class FCTRL {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while(T >0){
            T--;
            Long num = Long.parseLong(br.readLine());
            Long ans = 0L,factor =5L;
            while(num >= factor){
                ans += (num/factor);
                factor *= 5;
            }
            System.out.println(ans);
        }
    }
}
