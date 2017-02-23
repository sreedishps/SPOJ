import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish on 20/3/16.
 */
public class ALTARAY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            Integer op[] = new Integer[N];

            boolean positiveFlag = true;
            Integer counter = 0;

            for (int i = s.length - 1; i >= 0; i--) {
                if (counter == 0) {
                    if (Integer.parseInt(s[i]) > 0) {
                        positiveFlag = true;
                    } else {
                        positiveFlag = false;
                    }
                    counter = 1;
                    op[i] = counter;
                } else {
                    if (Integer.parseInt(s[i]) > 0 && !positiveFlag) {
                        positiveFlag = true;
                        counter++;
                    } else if (Integer.parseInt(s[i]) < 0 && positiveFlag) {
                        positiveFlag = false;
                        counter++;
                    }else if(Integer.parseInt(s[i]) > 0){
                        positiveFlag = true;
                        counter = 1;
                    } else if(Integer.parseInt(s[i]) < 0){
                        positiveFlag = false;
                        counter = 1;
                    }
                    op[i] = counter;
                }
            }


            for( int i =0;i< op.length -1  ; i++){
                System.out.print(op[i] + " ");
            }
            System.out.print(op[op.length-1] + "\n");

        }
    }
}
