import java.io.*;
import java.math.*;
import java.util.*;
public class UJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {StringTokenizer s = new StringTokenizer(br.readLine());BigInteger N = new BigInteger(s.nextToken());Integer D = Integer.parseInt(s.nextToken());if(N.equals(BigInteger.ZERO) && D.equals(0)){break;}System.out.println(N.pow(D));}
    }
}
