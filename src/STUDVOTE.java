import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/30/2016.
 */
public class STUDVOTE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer K = Integer.parseInt(temp[1]);

            temp = br.readLine().split(" ");

            Integer inp[] = new Integer[N];
            int vote[] = new int[N];
            boolean invalid[] = new boolean[N];

            for (int i = 0; i < N; i++) {
                vote[i] = 0;
            }

            for (int i = 0; i < N; i++) {
                inp[i] = Integer.parseInt(temp[i]);
                if (inp[i] == i+1) {
                    invalid[i] = true;
                }
                vote[inp[i]-1]++;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (vote[i] >= K && !invalid[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
