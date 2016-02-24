import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 1/24/16.
 */
public class DESTROY {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Integer T = sc.nextInt();
        while (T-- > 0) {
            Integer N = sc.nextInt();
            int bomb = 0;
            Long current = null;
            Long currentCounter = 0l;
            while (N-- > 0){
                Long next = sc.nextLong();
                if(current == null){
                    current = next;
                    currentCounter = 1l;
                    continue;
                }

                if(current.equals(next)){
                    currentCounter++;
                    continue;
                }else {
                    currentCounter--;
                    bomb++;
                    if(currentCounter.equals(0l)){
                        current = null;
                    }
                }

            }
            System.out.println(bomb+currentCounter);
        }
    }
}
