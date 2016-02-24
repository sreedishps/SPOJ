import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 2/3/16.
 */
public class ANARC08H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer D = Integer.parseInt(temp[1]);
            if (N == 0 && D == 0) {
                break;
            }

            boolean flag[] = new boolean[N];
            int current = 0;
            int skip = 0;
            for (int i = 1; i < N; i++) {
                if(!flag[current] && skip == (D-1)){
                    flag[current] = true;
                    current++;
                    current %= N;
                    skip = 0;
                    continue;
                }
                if (!flag[current]) {
                    skip++;
                    current++;
                    current %= N;
                    continue;
                }
                if(flag[current]){
                    current++;
                }
            }

            for (int i = 0; i < N; i++) {
                if (!flag[i]) {
                    System.out.println(N + " " + D + " " + (i + 1));
                }
            }
        }
    }
}
