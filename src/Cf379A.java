import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish on 15/11/16.
 */
public class Cf379A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String temp = br.readLine();

        int  anton = 0, danton = 0;
        for(int i = 0 ; i < N ; i++){
            if(temp.charAt(i) == 'A'){
                anton++;
            }else {
                danton++;
            }
        }

        if(anton > danton){
            System.out.println("Anton");
        }else if(anton < danton){
            System.out.println("Danik");
        }else {
            System.out.println("Friendship");
        }
    }
}
