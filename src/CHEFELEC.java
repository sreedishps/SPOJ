import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/3/2016.
 */
public class CHEFELEC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String yesOrNo = br.readLine();
            String distance[] = br.readLine().split(" ") ;

            boolean power[] = new boolean[N];
            Long coordinates[] = new Long[N];

            for (int i = 0; i < N; i++) {
                if (yesOrNo.charAt(i) == '1') {
                    power[i] = true;
                } else {
                    power[i] = false;
                }
                coordinates[i] = Long.parseLong(distance[i]);
            }

            long totalWire = 0;
            int leftMost = 0;
            for (int i = 0; i < N; i++) {
                if(power[i]){
                    leftMost = i;
                    break;
                }
            }

            totalWire += coordinates[leftMost] - coordinates[0];

            int rightMost = 0;
            for(int i = N-1 ; i >=0 ;i--){
                if(power[i]){
                    rightMost = i;
                    break;
                }
            }

            totalWire += coordinates[N-1] - coordinates[rightMost];

            while (leftMost < rightMost){
                long bigGap = 1;
                int i ;
                for (i = leftMost + 1; i < N  ; i++){
                    if(bigGap < (coordinates[i] - coordinates[i-1])){
                        bigGap = coordinates[i] - coordinates[i-1];
                    }
                    if(power[i]){
                        break;
                    }
                }

                if(i > rightMost){
                    break;
                }
                totalWire += (coordinates[i] - coordinates[leftMost]);
                totalWire -= bigGap;
                leftMost = i;
            }



            System.out.println(totalWire);


        }
    }
}
