import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FCTRL3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());

            Integer five = 5;
            Integer counter = 0;
            while (five <= N){
                counter += (N/five);
                five = five * 5;
            }

            System.out.println(counter);
        }
    }
}
