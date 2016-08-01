import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 6/26/2016.
 */
public class STICKS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            if(N < 3){
                System.out.println("-1");
                continue;
            }
            int inp[] = new int[N];
            int count[] = new int[1010];
            for (int i = 0; i < 1010; i++) {
                count[i] = 0;
            }

            String temp[] = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                count[Integer.parseInt(temp[i])]++;
            }

            int firstBest = getBest(count);
            if(firstBest == -1){
                System.out.println("-1");
                continue;
            }
            count[firstBest] -=2;
            int secondBest = getBest(count);
            if(secondBest == -1){
                System.out.println("-1");
                continue;
            }

            System.out.println(firstBest * secondBest);
        }
    }

    private static int getBest(int[] count) {
        int max = -1;
        for (int i = 1 ; i < 1010; i++) {
            if(count[i] >1 && count[i] > max){
                max = i;
            }
        }
        return max;
    }
}
