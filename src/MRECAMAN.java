import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 11/13/15.
 */
public class MRECAMAN {
    public static void main(String[] args) throws IOException {
        int a[] = new int[500001];
        HashSet<Integer> hs = new HashSet<Integer>();
        a[0] = 0;
        for(int i = 1;i<= 500000 ; i++){
            int temp = a[i-1] - i;
            if(temp > 0 && !hs.contains(temp)){
                hs.add(temp);
                a[i] = temp;
            }else {
                temp = a[i-1] + i;
                hs.add(temp);
                a[i] = temp;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            Integer N = Integer.parseInt(br.readLine());
            if(N.equals(-1)){
                break;
            }
            System.out.println(a[N]);
        }
    }
}
