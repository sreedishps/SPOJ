import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 12/14/15.
 */
public class NHAY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = br.readLine()) != null){
            Integer N = Integer.parseInt(temp);
            String needle = br.readLine();
            String hay = br.readLine();

            Integer lps[] = new Integer[N];
            computeLps(lps,N,needle);
            //printLps(lps,N);

            for(int i = 0;i<hay.length();i++){

            }
        }

    }

    private static void printLps(Integer[] lps, Integer N) {
        for(int i =0;i<N;i++){
            System.out.print(lps[i]+" ");
        }
        System.out.println();
    }

    private static void computeLps(Integer[] lps, Integer N, String needle) {
        lps[0] = 0;
        int len = 0;

        for(int i = 1;i<N;i++){
            if(needle.charAt(i) == needle.charAt(len)){
                lps[i] = lps[i-1] +1;
                len++;
                continue;
            }else {
                lps[i] = 0;
                len =0;
            }
        }

    }
}
