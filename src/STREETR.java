import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 1/26/16.
 */
public class STREETR {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(in.readLine());
        Integer trees[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(in.readLine());
        }

        int gcd = trees[1]- trees[0];
        for (int i = 2; i < N; i++) {
            gcd = gcd(gcd,trees[i] - trees[i-1]);
        }

        int a = trees[0];
        int t = trees[N-1];

        int numberOfTrees = ((t-a) / gcd) + 1 - N;
        System.out.println(numberOfTrees);

    }

    private static int gcd(int a, int b) {
        if( b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}
