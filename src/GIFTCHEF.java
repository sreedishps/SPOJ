import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 11/4/2016.
 */
public class GIFTCHEF {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String hayStack = br.readLine();
            String needle = br.readLine();
            int lastIndex = 0;
            int count =0;

            while(lastIndex != -1){
                lastIndex = hayStack.indexOf(needle,lastIndex);
                if(lastIndex != -1){
                    count ++;
                    System.out.println(lastIndex);
                    lastIndex++;
                }
            }
        }

    }
}
