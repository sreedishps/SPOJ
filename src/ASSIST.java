import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 6/13/2016.
 */
public class ASSIST {
    public static void main(String[] args) throws IOException {
        int limit = 34000;
        boolean sieve[] = new boolean[limit];
        int answer[] = new int[3500];
        int answerIndex = 1;

        for(int i = 2; i< limit ; i++){
            if(sieve[i]){
                continue;
            }
            answer[answerIndex] = i;
            answerIndex++;
            int counter = 0 ;
            for(int j = i+1 ; j < limit ; j++)
            {

                if(!sieve[j]){
                    counter++;
                }

                if(counter == i){
                    sieve[j] = true;
                    counter = 0;
                }
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            Integer n = Integer.parseInt(br.readLine());
            if(n.equals(0)){
                break;
            }



            System.out.println(answer[n]);
        }
    }
}
