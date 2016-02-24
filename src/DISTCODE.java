import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 12/27/15.
 */
public class DISTCODE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            HashSet<String> set = new HashSet<>();
            for(int i=1;i<str.length();i++){
                 set.add(str.charAt(i-1) + ""+str.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}
