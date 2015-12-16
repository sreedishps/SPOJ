import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/18/15.
 */
public class CPRMT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a, b;
        while ((a = br.readLine()) != null) {
            b = br.readLine();
            solve(a, b);
        }

    }

    private static void solve(String a, String b) {
        int m = a.length();
        int n = b.length();
        int aMap[] = new int[26];
        int common[] = new int[26];
        for(int i =0; i < m;i++){
            char temp = a.charAt(i);
            if (temp >= 'a' && temp <= 'z')
            aMap[temp - 'a']++;
        }

        for (int j=0;j<n;j++){
            char temp = b.charAt(j);
            if(aMap[temp - 'a'] > 0){
                aMap[temp - 'a']--;
                common[temp - 'a']++;
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i =0;i<26;i++){
            while (common[i] > 0){
                str.append((char)( 'a'+ i));
                common[i]--;
            }
        }
        System.out.println(str);
    }
}
