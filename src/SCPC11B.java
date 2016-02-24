import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 1/25/16.
 */
public class SCPC11B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            int N = in.nextInt();
            if(N == 0){
                break;
            }

            ArrayList<Integer> points = new ArrayList<>();
            for(int i =0;i<N;i++){
                int temp = in.nextInt();
                points.add(temp);
                points.add(1422 + (1422 - temp ));
            }
            Collections.sort(points);

            int first = 0,second = 0;
            boolean flag = true;
            for (int point : points){
                first = second;
                second = point;
                if(second - first > 200){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
