import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/18/15.
 */
public class MFLAR10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp = br.readLine();
            if (temp.startsWith("*")) {
                break;
            }
            solve(temp);
        }

    }

    private static void solve(String temp) {
        String arr[] = temp.split(" ");
        char beg = arr[0].charAt(0);
        boolean check = true;
        for (int i = 1; i < arr.length; i++) {
            if (same(beg, arr[i].charAt(0))) {
                continue;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }

    private static boolean same(char a, char b) {

        a = toSmall(a);
        b = toSmall(b);
        if (a == b) {
            return true;
        }

        return false;
    }

    private static char toSmall(char a) {
        if(a >= 'A' && a <= 'Z'){
            a =(char)( a - 'A' + 'a');
        }
        return a;
    }
}
