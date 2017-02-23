import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish on 15/11/16.
 */
public class CF379B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        Integer two = Integer.parseInt(temp[0]);
        Integer three = Integer.parseInt(temp[1]);
        Integer five = Integer.parseInt(temp[2]);
        Integer six = Integer.parseInt(temp[3]);

        Long sum = 0l;

        Integer min256 = Math.min(two, Math.min(five,six));

        sum += (256 * min256);

        two -= min256;

        Integer min32 = Math.min(two,three);

        sum += (32 * min32);

        System.out.println(sum);
    }
}
