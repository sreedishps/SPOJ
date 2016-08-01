import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreps on 7/30/2016.
 */
public class LUMPYBUS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Long P = Long.parseLong(temp[1]);
            Long Q = Long.parseLong(temp[2]);

            temp = br.readLine().split(" ");

            Long inp[] = new Long[N];
            for (int i = 0; i < N; i++) {
                inp[i] = Long.parseLong(temp[i]);
            }

            Arrays.sort(inp);
            Long count = 0L;

            for (int i = 0; i < N; i++) {
                Long two = 0L, one = 0L;

                if (inp[i] <= (2 * Q)) {
                    two = inp[i] / 2;
                    inp[i] = inp[i] - (2 * two);
                    Q = Q - two;
                }else {
                    inp[i] -= (2 * Q);
                    two = Q;
                    Q = 0L;
                }

                if (inp[i] <= P) {
                    one = inp[i];
                    inp[i] = inp[i] - one;
                    P = P - one;
                }

                if (inp[i] == 0) {
                    count++;
                } else {
                    Q += two;
                    P += one;
                }

                if (P == 0 && Q == 0) {
                    break;
                }

            }

            System.out.println(count);


        }
    }
}
