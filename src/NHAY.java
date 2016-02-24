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
        while ((temp = br.readLine()) != null) {
            Integer N = Integer.parseInt(temp);
            String needle = br.readLine();
            String hay = br.readLine();
            Integer M = needle.length();

            Integer lps[] = new Integer[N];
            computeLps(lps, N, needle);
         //   printLps(lps, N);

            int j=0,i=0;
            boolean flag = true;
            while (i< hay.length()) {
                if(hay.charAt(i) == needle.charAt(j)){
                    j++;
                    i++;
                }
                if(M.equals(j)){
                    flag = false;
                    System.out.println(i-j);
                    j=lps[j-1];
                }else if(i< hay.length() && hay.charAt(i) != needle.charAt(j)){
                    if(j != 0){
                        j = lps[j-1];
                    }else {
                        i = i+1;
                    }
                }
            }

            if(flag){
                System.out.println();
            }

        }

    }

    private static void printLps(Integer[] lps, Integer N) {
        for (int i = 0; i < N; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
    }

    private static void computeLps(Integer[] lps, Integer M, String needle) {
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < M) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

    }
}
