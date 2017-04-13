import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sreps on 4/13/2017.
 */
public class SIMDISH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
               String temp[] = br.readLine().split(" ");
            HashSet<String> hs1 = new HashSet<String>();

            for(int i = 0 ; i< 4 ; i++){
                hs1.add(temp[i]);
            }
            temp= br.readLine().split(" ");

            int counter = 0;
            for(int i = 0 ; i< 4 ; i++){
               if(hs1.contains(temp[i])){
                   counter++;
               }
            }

            if(counter >= 2){
                System.out.println("similar");
            }else {
                System.out.println("dissimilar");
            }
        }
    }
}
