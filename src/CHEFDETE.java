import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by sreedish.ps on 2/5/16.
 */
public class CHEFDETE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String temp[] = br.readLine().split(" ");
        TreeSet<Integer> killers = new TreeSet<>();
        for(int i =1; i <=N ; i++){
            killers.add(i);
        }

        for( int i=0;i<N;i++){
            killers.remove(Integer.parseInt(temp[i]));
        }

        for(int i:killers){
            System.out.print(i+" ");
        }
    }
}

