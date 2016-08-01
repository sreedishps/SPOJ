import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 7/24/2016.
 */
public class CHEFIHG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");

        Integer N = Integer.parseInt(temp[0]);
        Integer M = Integer.parseInt(temp[1]);

        Integer arr[][] = new Integer[N][M];

        for(int i = 0 ; i< N ; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < M ; j++){
                if(temp[j].equals("*")){
                    arr[i][j] = 1;
                }else   if(temp[j].equals(".")){
                    arr[i][j] = 2;
                }else {
                    arr[i][j] = 3;
                }
            }
        }

        //move everything to bottom right

    }
}
