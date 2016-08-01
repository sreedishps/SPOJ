import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by sreps on 6/12/2016.
 */
public class BANDW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temp[] = br.readLine().split(" ");
            if(temp[0].equals("*")){
                break;
            }
            int answer = check(temp[0], temp[1]);
            System.out.println(answer);

        }
    }

    private static int check(String original, String temp) {
        int irr = 0;
        for (int i = 0; i < original.length(); i++) {
            boolean entryFlag = true;
            while (original.charAt(i) != temp.charAt(i)) {
                if (entryFlag) {
                    irr++;
                    entryFlag = false;
                }
                i++;
                if (i == original.length()) {
                    i--;
                    break;
                }
            }
        }
        return irr;
    }
}
