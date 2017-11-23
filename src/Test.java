import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 4/14/2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp = br.readLine();
            if(temp.equals("42")){
                break;
            }
            System.out.println(temp);
        }
    }
}
