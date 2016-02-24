import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by sreedish.ps on 2/21/16.
 */
public class PPCTS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];
        temp = br.readLine().split(" ");
        Integer N = Integer.parseInt(temp[0]);
        Integer M = Integer.parseInt(temp[1]);

        Integer xCatch[] = new Integer[N];
        Integer yCatch[] = new Integer[N];

        int i = 0, j = 0;
        Integer total = 0;

        while (i < N) {
            temp = br.readLine().split(" ");
            Integer X = Integer.parseInt(temp[0]);
            Integer Y = Integer.parseInt(temp[1]);

            xCatch[i] = X;
            yCatch[i] = Y;


            total += Math.abs(X);
            total += Math.abs(Y);

            i++;
        }

        Arrays.sort(xCatch);
        Arrays.sort(yCatch);

        String traverse = br.readLine();

        for (i = 0; i < N; i++) {
            if (xCatch[i] >= 0) {
                break;
            }
        }


        for (j = 0; j < N; j++) {
            if (yCatch[j] >= 0) {
                break;
            }
        }


        Integer currentX = 0, currentY = 0;

        for (int t = 0; t < M; t++) {
            if (traverse.charAt(t) == 'U') {
                currentY++;
                while (j < N && yCatch[j] < currentY) {
                    j++;
                }
            } else if (traverse.charAt(t) == 'D') {
                currentY--;
            } else if (traverse.charAt(t) == 'L') {
                currentX++;
            } else if (traverse.charAt(t) == 'R') {
                currentX--;
            }
        }
    }
}
