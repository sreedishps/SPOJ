import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 12/6/15.
 */
public class PLANEDIV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            Long A[] = new Long[N];
            Long B[] = new Long[N];
            Long C[] = new Long[N];
            Integer xParallel = 0,yParallel = 0;

            HashMap<Double, HashSet<Double>> hm = new HashMap<Double, HashSet<Double>>();
            for (int i = 0; i < N; i++) {
                String temp[] = br.readLine().split(" ");
                A[i] = Long.parseLong(temp[0]);
                B[i] = Long.parseLong(temp[1]);
                C[i] = Long.parseLong(temp[2]);

                if (A[i].equals(0)) {
                    yParallel++;
                    continue;
                }
                if (B[i].equals(0)) {
                    xParallel++;
                    continue;
                }
                Double slope = 0.0, inter = 0.0;

                slope = (double) A[i] / (double) B[i];
                inter = (double) C[i] / (double) B[i];

                if (hm.get(slope) == null) {
                    HashSet hs = new HashSet();
                    hs.add(inter);
                    hm.put(slope, hs);
                } else {
                    hm.get(slope).add(inter);
                }
            }

            Integer max = 0;
            for (HashSet hs : hm.values()) {
                if (hs.size() > max) {
                    max = hs.size();
                }
            }

            if(max < xParallel){
                max = xParallel;
            }

            if(max < yParallel){
                max = yParallel;
            }

            System.out.println(max);

        }
    }
}