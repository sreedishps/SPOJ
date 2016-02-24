import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 1/10/16.
 */
public class FIBOSUM {

    public static long modulo = 1000000007l;
    public static long[][] product;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);
            product = new long[2][2];
            System.out.println((sum(M) + modulo - sum(N-1)) % modulo);
        }
    }

    private static long sum(Integer m) {
        return fib(m + 2) - 1;
    }

    public static long fib(long n){
        if(n == 0 ){
            return 0;
        }
        long F[][] = {{1,1},{1,0}};
        powerIt(F,n-1);
        return F[0][0];
    }

    public static void powerIt(long[][] matrix, long n) {
        if (n == 0 || n == 1) {
            return;
        }

        powerIt(matrix, n / 2);
        multiply(matrix, matrix);

        if (n % 2 == 1) {
            long M[][] = {{1, 1}, {1, 0}};
            multiply(matrix, M);
        }
    }

    public static void multiply(long[][] a, long[][] b) {
        long product[][] = new long[2][2];
        product[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % modulo;
        product[0][1] = (a[0][0] * b[1][0] + a[0][1] * b[1][1]) % modulo;
        product[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % modulo;
        product[1][1] = (a[1][0] * b[1][0] + a[1][1] * b[1][1]) % modulo;

        copy(product, a);
    }

    private static void copy(long[][] product, long[][] a) {
        a[0][0] = product[0][0];
        a[0][1] = product[0][1];
        a[1][0] = product[1][0];
        a[1][1] = product[1][1];
    }
}
