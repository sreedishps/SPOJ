import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sreedish on 20/3/16.
 */
public class ONOZ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        HashSet<Integer> doubles = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            doubles.add(i);
        }

        for (int i = 11; i < 100; i += 11) {
            doubles.add(i);
        }

        while (T-- > 0) {
            String t[] = br.readLine().split(" ");
            Integer H = Integer.parseInt(t[0]);
            Integer M = Integer.parseInt(t[1]);


            int counter  = 0 ;
            for (int i = 0; i < H; i++) {
                if (!doubles.contains(i)) {
                    continue;
                }

                for (int j = 0; j < M; j++) {
                    if (!doubles.contains(j)) {
                        continue;
                    }

                    if((j%10) !=( i % 10)){
                        continue;
                    }

                   // System.out.println(i + " "+j);
                   counter++;
                }
            }


            System.out.println(counter);
        }
    }
}
