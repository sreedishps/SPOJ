import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 1/8/16.
 */
public class ACPC10D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = 1;
        while (true) {
            Integer N = Integer.parseInt(br.readLine());
            if (N.equals(0)) {
                break;
            }
            Integer left = 0, middle = 0, right = 0;
            String temp[] = br.readLine().split(" ");
            Integer L = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);
            Integer R = Integer.parseInt(temp[2]);
            left = Integer.MAX_VALUE;
            middle = M;
            right = R + middle;
            N--;
            while (N-- > 0) {
                temp =br.readLine().split(" ");
                L = Integer.parseInt(temp[0]);
                M = Integer.parseInt(temp[1]);
                R = Integer.parseInt(temp[2]);

                Integer leftTemp = Math.min(left,middle) + L;
                Integer middleTemp = Math.min( Math.min(left,leftTemp),Math.min(middle,right) ) + M;
                Integer rightTemp = Math.min(Math.min(middleTemp,middle) ,right) + R;

                left = leftTemp;
                right = rightTemp;
                middle = middleTemp;
            }
            System.out.println(counter + ". "+middle);
            counter++;
        }
    }
}
