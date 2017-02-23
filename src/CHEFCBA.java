import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreps on 7/24/2016.
 */
public class CHEFCBA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");

        Integer arr[] = new Integer[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(arr);

        if((arr[0] * arr[3]) == (arr[1] * arr[2])){
            System.out.println("Possible");
        }else {
            System.out.println("Impossible");
        }
    }
}
