import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by sreedish.ps on 2/12/16.
 */
public class BYTESE2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            TreeSet<Integer> entry = new TreeSet<Integer>();
            TreeSet<Integer> exits = new TreeSet<Integer>();
            while (N-- > 0) {
                String temp[] = br.readLine().split(" ");
                entry.add(Integer.parseInt(temp[0]));
                exits.add(Integer.parseInt(temp[1]));
            }

            int max = -1, count = 0;
            while (!entry.isEmpty()) {
                if (entry.first() < exits.first()) {
                    entry.pollFirst();
                    count++;
                    if (max < count) max = count;
                } else {
                    exits.pollFirst();
                    count--;
                }
            }

            System.out.println(max);
        }
    }
}
