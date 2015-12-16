import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 12/6/15.
 */
public class CHEFST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            Long N1 = Long.parseLong(temp[0]);
            Long N2 = Long.parseLong(temp[1]);
            Long M = Long.parseLong(temp[2]);

            Long differece = 0L;
            Long maximum = (M * ( M +1 ))/2;
            if(N1 > N2){
                Long t = N1;
                N1 = N2;
                N2 = t;
            }

            if(N1 <= maximum){
                System.out.println(N2 - N1);
            }else {
                differece += (N1 - maximum );
                differece += (N2 - maximum );
                System.out.println(differece);
            }

        }
    }
}
