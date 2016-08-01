import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

/**
 * Created by sreps on 5/3/2016.
 */
public class BINSTIRL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            Integer n = Integer.parseInt(temp[0]);
            Integer k = Integer.parseInt(temp[1]);
            if(((n-k)&(k-1)/2) == 0)
                System.out.println("1");
            else
                System.out.println("0");
        }


    }
}
