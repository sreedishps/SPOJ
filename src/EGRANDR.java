import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/3/2016.
 */
public class EGRANDR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp[] = br.readLine().split(" ");

            boolean flag5 = false;
            boolean flag2 = false;
            Integer total = 0;
            for (int i = 0; i < N; i++) {
                Integer mark = Integer.parseInt(temp[i]);
                if (mark == 5) {
                    flag5 = true;
                }
                if (mark == 2) {
                    flag2 = true;
                    break;
                }
                total += mark;
            }

            if(flag2){
                System.out.println("No");
                continue;
            }

            if(flag5){
                if(total >= (N * 4)){
                    System.out.println("Yes");
                    continue;
                }
            }

            System.out.println("No");

        }
    }
}
