import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/24/2016.
 */
public class CHEFFED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer inp = Integer.parseInt(br.readLine());

        int count = 0;

        for(Integer i = inp - 110; i <= inp ; i++){
            Integer temp1 = s(i);
            Integer temp2 = s(temp1);

            if((i + temp1 + temp2) == inp){
               // System.out.println(i);
                count++;
            }
        }

        System.out.println(count);

    }

    public static int s(Integer temp){
        int answer = 0;

        while (temp > 0){
            answer += temp % 10;
            temp = temp/10;
        }
        return answer;
    }
}
